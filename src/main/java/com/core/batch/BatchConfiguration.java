package com.core.batch;


import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.model.Mouvement;
import com.core.model.Project;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	
	final Logger logger = Logger.getLogger(BatchConfiguration.class);

	/**
	 * 
	 * @return
	 * @throws MalformedURLException 
	 */
	@Bean
	public ItemReader<Project> reader() {
		logger.info("------------------------- Lecture des donn�es ------------------------------");
		return new SmartContractReader();
	}
	
	@Bean
	public ItemProcessor<Project, Project> processor() {
		logger.info("-------------------------Transformation des donn�es ------------------------------");
		return new SmartContractProcessor();
	}

	@Bean
	public ItemWriter<Project> writer() {
		logger.info("-------------------------Ecriture des donn�es en base ------------------------------");
		return new SmartContractWriter();
	}
	
	
	/**
	 * @param stepBuilderFactory
	 * @return
	 */
	@Bean
	public Step mouvementStep(StepBuilderFactory stepBuilderFactory, ItemReader<Project> reader,ItemWriter<Project> writer,
			ItemProcessor<Project, Project> processor){
		return stepBuilderFactory.get("mouvementStep")
	            .<Project, Project> chunk(10)
	            .reader(reader)
	            .processor(processor)
	            .writer(writer)
	            .build();	
	}
	/**
	 * la d�claration du mouvementJob 
	 * @return
	 */
	@Bean
	public Job mouvementJob(JobBuilderFactory jobs, Step step1){
		 return jobs.get("mouvementJob")
		            .incrementer(new RunIdIncrementer())
		            .flow(step1)
		            .end()
		            .build();
		
	}
	

}