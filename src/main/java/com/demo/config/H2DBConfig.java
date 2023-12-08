package com.demo.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.demo.repository"})
public class H2DBConfig {

	 @Bean
	  @Primary
	  @ConfigurationProperties(prefix = "spring.datasource")
	  public DataSource db1DataSource() {
	    return DataSourceBuilder.create().build();
	  }
	 
}
