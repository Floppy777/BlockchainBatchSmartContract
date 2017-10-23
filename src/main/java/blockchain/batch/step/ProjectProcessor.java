package blockchain.batch.step;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import blockchain.batch.config.Context;
import blockchain.batch.model.EthereumAccount;
import blockchain.batch.model.Project;

public class ProjectProcessor implements ItemProcessor<Project, Project> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProcessor.class);
    
    private Web3j web3;
    
	private final String SQL = "SELECT * FROM ethereum_account WHERE ethereum_address = ? AND password = ?";
	
	private EthereumAccount ethereumAccount ;
	
	@Autowired
	private Context context;
    
    @Autowired
    private DataSource datasource;
           
    public ProjectProcessor(){
        web3 = Web3j.build(new HttpService());
    	LOGGER.info("Web 3 : " + web3);
    }
    
    @PostConstruct
    public void initialize(){
    	JdbcTemplate jdbc = new JdbcTemplate(datasource);
        List<EthereumAccount> list = jdbc.query(SQL, new RowMapper<EthereumAccount>() {
			@Override
			public EthereumAccount mapRow(ResultSet rs, int arg1) throws SQLException {
				EthereumAccount ethAccount = new EthereumAccount(rs.getString("ethereum_address"), rs.getString("password"),rs.getString("file"));
				return ethAccount;
			}
		},context.getAccount().getAddress(),context.getAccount().getPassword());
        ethereumAccount = list.get(0);
    }
  

    @Override
    public Project process(Project item) throws Exception {
        LOGGER.info("Processing Record: {}", item);
        if(item == null){
        	LOGGER.info("EXIT item NULL ");
        	return null;
        }
        if(item.getAddress() == null){
        	LOGGER.info("EXIT item address NULL");
        	return null;
        }
        if(ethereumAccount == null){
        	LOGGER.info("EXIT Eth Account NULL");
        	return null;
        }
       
        /*
        ClientTransactionManager clientTransactionManager = new ClientTransactionManager(web3,"");
        ProjectSmartContract contract = ProjectSmartContract.load("", web3, clientTransactionManager, GAS_PRICE, GAS_LIMIT);
        LOGGER.info("INSTANCE WEB3 : " + web3);

        
        contract.getAmount().get();
        contract.getAmountWanted().get();
        contract.getNbDonation().get();
        
        
        LOGGER.info("Amount Total : " + contract.getAmount());
        LOGGER.info("Amount Wanted : " + contract.getAmountWanted());
        LOGGER.info("Nb donation" + contract.getNbDonation());
        
        */
        
        LOGGER.info("Address : " + context.getAccount().getAddress());
        item.setAmountTotal((float) 10.0);
        item.setAmountWanted((float) 10.00);
        item.setNbDonation(12);
        item.setUpdatedAt(new Date(Calendar.getInstance().getTimeInMillis()));

        return item;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
     * String hexPrivateKey = String.format("%040x", new BigInteger(1, privateKey.getBytes()));
	   String hexPublicKey = String.format("%040x", new BigInteger(1, publicKey.getBytes()));  
       Credentials creds = Credentials.create(hexPrivateKey, hexPublicKey);

     */
}

