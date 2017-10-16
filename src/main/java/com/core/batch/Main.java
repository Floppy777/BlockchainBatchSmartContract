package com.core.batch;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Main {
	  public static void main(String [] args) {		
			final Logger logger = Logger.getLogger(Main.class);	
			logger.info("---------------------Excécution du batch dernier movement-----------------------------");
	    	SpringApplication.run(Main.class, args);		
			logger.info("---------------------FIN Excécution du batch dernier movement----------------------------");
	  }
}