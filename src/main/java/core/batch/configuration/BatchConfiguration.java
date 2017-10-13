package core.batch.configuration;
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

import core.batch.model.Project;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

	@Bean
	public ItemReader<Project> itemReader(){
		return new SmartContractReader();
	}
	
	@Bean
	public ItemProcessor<Object,Object> itemProcessor(){
		return new SmartContractProcessor();
	}
	
	@Bean
	public ItemWriter<Object> itemWriter(){
		return new SmartContractWriter();
	}
	
	@Bean
	public Step smartContractStep(StepBuilderFactory stepBuilderFactory,ItemReader<Project> itemReader,ItemProcessor<Object,Object> itemProcessor, ItemWriter<Object> itemWriter){
		return stepBuilderFactory
				.get("smartContractStep").<Object,Object> chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
	
	@Bean
	public Job smartContractJob(JobBuilderFactory jobs, Step step1){
		return jobs.get("smartContractJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1)
				.end()
				.build();
	}
}
