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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory2",
transactionManagerRef = "entityTransactionManager2",
basePackages = { "com.demo.h2.repository" })
public class H2DBConfig {

	@Bean(name ="datasource2")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource db2DataSource() {
		
		return DataSourceBuilder.create()
        .driverClassName("org.h2.Driver")
        .url("jdbc:h2:mem:db")
        .username("sa")
        .password("")
        .build();
		
		//return DataSourceBuilder.create().build();
	}

	//@Primary
	@Bean(name = "entityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2(EntityManagerFactoryBuilder builder,
			@Qualifier("datasource2") DataSource dataSource) {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		

		return builder.dataSource(dataSource).properties(properties).packages("com.demo.entity.h2")
				.persistenceUnit("db").build();

	}

	//@Primary
	@Bean
	public PlatformTransactionManager entityTransactionManager2(
			@Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory2) {
		return new JpaTransactionManager(entityManagerFactory2);
	}

}
