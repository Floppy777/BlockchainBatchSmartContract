/**
 * 
 */
package com.core.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.core.model.Project;

/**
 * @author fchambon
 *
 */
public class SmartContractProcessor implements ItemProcessor<Project, Project>{
	
	final static Logger logger = Logger.getLogger(SmartContractProcessor.class);
	
	public SmartContractProcessor(){}
	
	@Override
	public Project process(Project p) throws Exception {
	
		
			return p;
		
	}
	

}
