package com.ig.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.ig.repo.mysql",
		entityManagerFactoryRef = "mysqlLCEMFB",
		transactionManagerRef = "mysqlJPATM"
		)
public class MySqlRepoConfig 
{

}
