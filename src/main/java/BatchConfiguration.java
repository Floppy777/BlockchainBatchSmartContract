import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

	@Bean
	public ItemReader<Object> itemReader(){
		return null;
	}
	
	@Bean
	public ItemProcessor<Object,Object> itemProcessor(){
		return null;
	}
	
	public ItemWriter<Object> itemWriter(){
		return null;
	}
	
	@Bean
	public Step mouvementStep(StepBuilderFactory stepBuilderFactory,ItemReader<Object> itemReader,ItemProcessor<Object,Object> itemProcessor, ItemWriter<Object> itemWriter){
		return stepBuilderFactory
				.get("smartContractStep").<Object,Object> chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
	}
}
