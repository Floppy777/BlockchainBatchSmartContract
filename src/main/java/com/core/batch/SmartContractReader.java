package com.core.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;

import com.core.model.Project;

public class SmartContractReader implements ItemReader<Project> {

	private int cursor;
	private int reached;

	final Logger logger = Logger.getLogger(SmartContractReader.class);

	public SmartContractReader() {
		cursor = 1;
		reached = 10;
	};

	@Override
	public Project read() {
		logger.info("Cursor : " + cursor);
		if(cursor == reached){
			return null;
		}
		else{
			cursor += 1;
			return new Project();
		}
	}
}