package org.jsp.hibtemplatedemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.jsp.hibtemplatedemo")
public class MerchantConfig {
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/hib_templ_ano?createDatabaseIfNotExist=true");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sF = new LocalSessionFactoryBean();
		sF.setDataSource(dataSource);
		sF.setPackagesToScan("org.jsp.hibtemplatedemo.dto");
		sF.setHibernateProperties(hibernateProperties());
		return sF;
	}

	@Bean
	public HibernateTemplate hibernateTemplate(LocalSessionFactoryBean sessionFactory) {
		return new HibernateTemplate(sessionFactory.getObject());
	}

	@Bean
	public PlatformTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
		return new HibernateTransactionManager(sessionFactory.getObject());
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

}
