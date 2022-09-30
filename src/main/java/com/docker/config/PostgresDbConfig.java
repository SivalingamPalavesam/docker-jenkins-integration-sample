
package com.docker.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
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

import liquibase.integration.spring.SpringLiquibase;

@Configuration

@EnableTransactionManagement

@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", transactionManagerRef = "postgresTransactionManager", basePackages = {
		"com.docker.repository.postgres" })
public class PostgresDbConfig {

	@Bean(name = "postgresDataSource")

	@ConfigurationProperties(prefix = "postgres.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource()).packages("com.docker.entity.postgres").persistenceUnit("postgres")
				.build();
	}

	@Bean(name = "postgresTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
		return new JpaTransactionManager(postgresEntityManagerFactory);
	}

	@Bean

	@ConfigurationProperties(prefix = "postgres.datasource.liquibase")
	public LiquibaseProperties secLiquibaseProperties() {
		return new LiquibaseProperties();
	}

	@Bean
	public SpringLiquibase secondaryLiquibase() {
		return springLiquibase(dataSource(), secLiquibaseProperties());
	}

	private SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(properties.getChangeLog());
		liquibase.setContexts(properties.getContexts());
		liquibase.setDefaultSchema(properties.getDefaultSchema());
		return liquibase;
	}
}
