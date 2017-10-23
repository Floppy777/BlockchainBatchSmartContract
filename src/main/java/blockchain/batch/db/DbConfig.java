package blockchain.batch.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEntityManager", 
		transactionManagerRef = "mysqlTransactionManager", 
		basePackages = "blockchain.batch.db"
)
public class DbConfig {
		
	@Autowired
	private Environment env;

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource mysqlDataSource() {
		DataSource datasource = DataSourceBuilder
			.create()
			.driverClassName(env.getProperty("spring.datasource.driverClassName"))
			.url(env.getProperty("spring.datasource.url"))
			.password(env.getProperty("spring.datasource.password"))
			.username(env.getProperty("spring.datasource.username")).build();
		return datasource;
	}

	

}
