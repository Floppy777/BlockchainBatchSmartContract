package blockchain.batch.step;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;

import blockchain.batch.model.Project;
import blockchain.batch.smartcontract.ProjectSmartContract;

public class ProjectProcessor implements ItemProcessor<Project, Project> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProcessor.class);
    
    private Web3j web3;
        
    private static final BigInteger GAS_PRICE = new BigInteger("2000");
    private static final BigInteger GAS_LIMIT = new BigInteger("4000");
    
    public ProjectProcessor(){
    	LOGGER.info("WEB3");
        Web3j.build(new HttpService());  
    }
    
    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.ItemProcessor#process(java.lang.Object)
     * String hexPrivateKey = String.format("%040x", new BigInteger(1, privateKey.getBytes()));
	   String hexPublicKey = String.format("%040x", new BigInteger(1, publicKey.getBytes()));  
       Credentials creds = Credentials.create(hexPrivateKey, hexPublicKey);

     */

    @Override
    public Project process(Project item) throws Exception {
        LOGGER.info("Processing Record: {}", item);
        if(item == null){
        	return null;
        }
        if(item.getAddress() == null){
        	return null;
        }
        
        ClientTransactionManager clientTransactionManager = new ClientTransactionManager(web3,"");
        ProjectSmartContract contract = ProjectSmartContract.load("", web3, clientTransactionManager, GAS_PRICE, GAS_LIMIT);
        LOGGER.info("INSTANCE WEB3 : " + web3);

        
        contract.getAmount().get();
        contract.getAmountWanted().get();
        contract.getNbDonation().get();
        
        LOGGER.info("Amount Total : " + contract.getAmount());
        LOGGER.info("Amount Wanted : " + contract.getAmountWanted());
        LOGGER.info("Nb donation" + contract.getNbDonation());
        
        item.setAmountTotal((float) 10.0);
        item.setAmountWanted((float) 10.00);
        item.setNbDonation(12);

        return item;
    }
}

