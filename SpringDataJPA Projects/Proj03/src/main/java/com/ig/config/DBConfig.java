package com.ig.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	@ConfigurationProperties(prefix = "mysql.datasource")
	@Bean(name = "mysqlDS")
	public DataSource createMySqlDS()
	{
		return DataSourceBuilder.create().build();
	}
	
	/*
	 * @ConfigurationProperties(prefix = "oracle.datasource")
	 * 
	 * @Bean(name = "oracleDS") public DataSource createOracleDS() { return
	 * DataSourceBuilder.create().build(); }
	 */
	
	@Bean(name = "mysqlLCEMFB")
	public LocalContainerEntityManagerFactoryBean createMySqlLCEMFB(EntityManagerFactoryBuilder builder)
	{
		Map<String, String> props = new HashMap();	
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		return builder.
					dataSource(createMySqlDS()).
					packages("com.ig.entity.mysql").
					properties(props).
					build();
	}
	
	/*
	 * @Bean(name = "oracleLCEMFB") public LocalContainerEntityManagerFactoryBean
	 * createOracleLCEMFB(EntityManagerFactoryBuilder builder) { Map<String, String>
	 * props = new HashMap(); props.put("hibernate.dialect",
	 * "org.hibernate.dialect.MySQL8Dialect"); props.put("hibernate.hbm2ddl.auto",
	 * "update"); props.put("hibernate.show_sql", "true"); return builder.
	 * dataSource(createOracleDS()). packages("com.ig.entity.oracle").
	 * properties(props). build(); }
	 */
	
	@Bean(name = "mysqlJPATM")
	public JpaTransactionManager createMySqlJPATransactionManager(@Qualifier("mysqlLCEMFB") EntityManagerFactory emfb)
	{
		return new JpaTransactionManager(emfb);
	}
	
	/*
	 * @Bean(name = "oracleJPATM") public JpaTransactionManager
	 * createOracleJPATransactionManager(@Qualifier("oracleLCEMFB")
	 * EntityManagerFactory emfb) { return new JpaTransactionManager(emfb); }
	 */
}
