package myproject.cviewer.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() throws IOException {
        final LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(hibernateProperties());
        factory.setPackagesToScan("myproject.cviewer.dto");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "dataSource", destroyMethod = "shutdown")
	public DataSource dataSource() {
 		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
			.setType(EmbeddedDatabaseType.H2)
			.addScript("schema.sql")
			.addScript("test-data.sql")
			.build();
		return db;
	}

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }

    private static Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.put("hibernate.max_fetch_depth", 3);
        hibernateProperties.put("hibernate.jdbc.fetch_size", 50);
        hibernateProperties.put("hibernate.jdbc.batch_size", 10);
        hibernateProperties.put("hibernate.show_sql", false);
        return hibernateProperties;
    }
}
