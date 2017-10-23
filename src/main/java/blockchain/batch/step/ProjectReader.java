package blockchain.batch.step;

import java.sql.ResultSet;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import blockchain.batch.model.Project;

public class ProjectReader implements ItemReader<Project> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectReader.class);

	private JdbcCursorItemReader<Project> reader = new JdbcCursorItemReader<>();

	@Autowired
	private DataSource datasource;

	
	@PostConstruct
	public void initialize() {
		reader.setSql("SELECT id, name, address FROM project");
		reader.setDataSource(datasource);
		reader.setFetchSize(1);
		reader.setRowMapper((ResultSet resultSet, int rowNum) -> {
			if (!(resultSet.isAfterLast()) && !(resultSet.isBeforeFirst())) {
				Project p = new Project();
				p.setId(resultSet.getInt(1));
				p.setName(resultSet.getString(2));
				p.setAddress(resultSet.getString(3));
				LOGGER.info("OBJECT : " + p);
				return p;
			} else {
				return null;
			}
		});
	}

	@Override
	public Project read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return reader.read();
	}

	@BeforeStep
	public void saveStepExecution(StepExecution stepExecution) {
		reader.open(stepExecution.getExecutionContext());
	}

}
