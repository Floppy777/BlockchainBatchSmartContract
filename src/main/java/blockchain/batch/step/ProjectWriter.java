package blockchain.batch.step;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import blockchain.batch.model.Project;

public class ProjectWriter implements ItemWriter<Project> {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectProcessor.class);
    
    private JdbcBatchItemWriter<Project> writer = new JdbcBatchItemWriter<>();
    
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
    	LOGGER.info("ProjectWriter");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setItemPreparedStatementSetter(new ItemPreparedStatementSetter<Project>() {
			@Override
			public void setValues(Project item, PreparedStatement ps) throws SQLException {
				LOGGER.info("Date " + item.getUpdatedAt());
				LOGGER.info("Date " + item.getEndDate());
				ps.setString(1, item.getName());
				ps.setString(2, item.getAddress());
				ps.setFloat(3,item.getAmountTotal());
				ps.setFloat(4, item.getAmountWanted());
				ps.setInt(5, item.getNbDonation());
				ps.setTimestamp(6, new Timestamp(item.getUpdatedAt().getTime()));
				ps.setTimestamp(7, new Timestamp(item.getEndDate().getTime()));
				ps.setBoolean(8, item.getIsClosed());
				ps.setInt(9, item.getProgress());
				ps.setLong(10, item.getId());

			}
		});
		writer.setSql("UPDATE project SET name=?, address=?, amount_total=?, amount_wanted=?, nb_donation=?, updated_at=?, end_date=?, is_closed = ?, progress = ?  WHERE id=?");
		writer.setDataSource(dataSource);	
    }

	@Override
	public void write(List<? extends Project> listProject) throws Exception {
		System.out.println("On passe ici ? ");
		System.out.println("List : " + listProject.size());
		writer.write(listProject);
	}
}
