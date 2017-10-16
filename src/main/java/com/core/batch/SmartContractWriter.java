package com.core.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import com.core.model.Project;

public class SmartContractWriter implements ItemWriter<Project> {

	final Logger logger = Logger.getLogger(SmartContractWriter.class);


	public SmartContractWriter() {

	}

	@Override
	public void write(List<? extends Project> p) throws Exception {

		

	}

}