package blockchain.batch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	
    public static void main(String[] args) throws Exception {	
    	LOGGER.info("Start");
        SpringApplication.run(Application.class, args);
        LOGGER.info("End ");
    }
}