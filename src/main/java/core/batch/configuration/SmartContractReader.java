package core.batch.configuration;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import core.batch.model.Project;

public class SmartContractReader implements ItemReader<Project> {
	
	int index = 0;
	int nbElement = 10;
	
	public SmartContractReader(){
		System.out.println("On passe la ");
	}

	@Override
	public Project read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Index : " + index);
		if(index < nbElement){
			index = index + 1;
			return new Project();
		}
		return null;
	}

}
