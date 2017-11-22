package blockchain.batch.step;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Wallet;
import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import com.fasterxml.jackson.databind.ObjectMapper;

import blockchain.batch.config.Context;
import blockchain.batch.model.Project;
import blockchain.batch.smartcontract.ProjectSmartContract;

public class ProjectProcessor implements ItemProcessor<Project, Project> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProcessor.class);
    
    private Web3j web3;
    	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private Context context;
	
	private Credentials credentials ;
	
	@Autowired 
	private DataSource datasource;
	
	private JdbcTemplate jdbc;
	
	private Date nowDate = new Date(Calendar.getInstance().getTimeInMillis());

	// Permet de gerer les nombres négatifs
	private static final BigInteger TWO_COMPL_REF = BigInteger.ONE.shiftLeft(64);

	
    public ProjectProcessor(){
        web3 = Web3j.build(new HttpService());
    	LOGGER.info("Web 3 : " + web3);
    }
    
    @PostConstruct
    public void initialize() throws Exception {
       JdbcTemplate jdbc = new JdbcTemplate(datasource);
       LOGGER.info("File UTC : " + context.getAccount().getFile());
       File utcFile = new File(context.getAccount().getFile());
       WalletFile walletFile = mapper.readValue(utcFile,WalletFile.class);
       ECKeyPair keyPair= Wallet.decrypt(context.getAccount().getPassword(), walletFile);
       credentials = Credentials.create(keyPair);       
    }
  

    @Override
    public Project process(Project item) throws Exception {
    	
    	/** Condition d'erreur **/
        if(item == null){
        	LOGGER.info("EXIT item NULL ");
        	return null;
        }
        if(item.getAddress() == null){
        	LOGGER.info("EXIT item address NULL");
        	return null;
        }
     
        try {
        	ProjectSmartContract contract = ProjectSmartContract.load(item.getAddress(), web3, credentials,new BigInteger("20000"),new BigInteger("700000"));            
            BigInteger amountTotal = parseBigIntegerPositive(contract.getAmount().get().getValue());
            Integer amountWanted = contract.getAmountWanted().get().getValue().intValue();
            Integer nbDonation = contract.getNbDonationTotal().get().getValue().intValue();
            
            
            LOGGER.info("Amount Total : " + amountTotal);
            LOGGER.info("Nb donation : " + nbDonation);
            LOGGER.info("Amount Wanted : " + amountWanted);
            BigDecimal amountTotalPositive = Convert.fromWei(new BigDecimal(amountTotal), Convert.Unit.ETHER);
            LOGGER.info("Eth : " + amountTotalPositive);
            LOGGER.info("Eth : " + amountTotalPositive.floatValue());
            LOGGER.info("Int " + contract.getDuration().get().getValue().intValue());
            LOGGER.info("Indo : " + (float)amountTotalPositive.floatValue() * 100 );
            LOGGER.info("Indo : " + (float)amountTotalPositive.floatValue() * 100 / amountWanted);
            Timestamp t = Timestamp.from(Instant.ofEpochSecond(contract.getDuration().get().getValue().intValue()));
            LOGGER.info("TimeStamp : " + t);
            LOGGER.info("Date : " + new Date(t.getTime()));
            item.setAmountTotal((float) amountTotalPositive.floatValue());
            item.setAmountWanted((float) amountWanted);
            item.setNbDonation(nbDonation);
            item.setUpdatedAt(new Date(Calendar.getInstance().getTimeInMillis()));
            item.setEndDate(new Date(t.getTime()));
            item.setProgress(amountTotalPositive.intValue() * 100 / amountWanted);
            
        	if(item.getEndDate() != null && item.getEndDate().before(nowDate)){
        		item.setIsClosed(true);
        	}
        	
        	LOGGER.info("Item : " + item);
            return item;	
        } catch (NullPointerException e){
        	//e.printStackTrace();
        	return null;
        }
    }    
    
    private BigInteger parseBigIntegerPositive(BigInteger  b) {
        if (b.compareTo(BigInteger.ZERO) < 0)
            b = b.add(TWO_COMPL_REF);
        return b;
    }
    
    
    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
     * String hexPrivateKey = String.format("%040x", new BigInteger(1, privateKey.getBytes()));
	   String hexPublicKey = String.format("%040x", new BigInteger(1, publicKey.getBytes()));  
       Credentials creds = Credentials.create(hexPrivateKey, hexPublicKey);

     */
}

