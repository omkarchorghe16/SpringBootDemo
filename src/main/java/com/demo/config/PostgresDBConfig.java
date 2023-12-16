package com.demo.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "entityTransactionManager1",
basePackages = { "com.demo.repository" })
public class PostgresDBConfig {

	@Bean(name ="datasource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource db1DataSource() {
		
		/*
		 * return DataSourceBuilder.create() .driverClassName("org.postgresql.Driver")
		 * .url("jdbc:postgresql://localhost:5432/db") .username("postgres")
		 * .password("postgres") .build();
		 */
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("datasource") DataSource dataSource) {
		
		HashMap<String,Object> properties= new HashMap<String,Object>();
		properties.put("hibernate.hbm2ddl.auto","update");
		
		return builder.dataSource(dataSource)
				.properties(properties)
				.packages("com.demo.entity")
				.persistenceUnit("db")
				.build();

	}
	
	 @Primary
	    @Bean
	    public PlatformTransactionManager entityTransactionManager1(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory){
	        return new JpaTransactionManager ( entityManagerFactory );
	    }
}
