package com.hibernate.practice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class BeanConfiguration {
	
	@Autowired
	private HibernateConfiguration hibernateConfiguration;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(hibernateConfiguration.getDriverClassName());
		driverManagerDataSource.setUrl(hibernateConfiguration.getUrl());
		driverManagerDataSource.setUsername(hibernateConfiguration.getUserName());
		driverManagerDataSource.setPassword(hibernateConfiguration.getPassword());
		return driverManagerDataSource;
	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", hibernateConfiguration.getDialect());
		hibernateProperties.put("hibernate.show_sql", hibernateConfiguration.getShowSql());
		hibernateProperties.put("hibernate.format_sql", hibernateConfiguration.getFormatSql());
		
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		return hibernateProperties;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean localSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("com.hibernate");
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		
//		localSessionFactoryBean.setAnnotatedClasses();
//		localSessionFactoryBean.setAnnotatedPackages("com.synergisticit.domain");
		return localSessionFactoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
//	@Bean
//	@Primary
//	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactory.setDataSource(dataSource());
//		entityManagerFactory.setPackagesToScan("com.practice.domain");
//		entityManagerFactory.setJpaProperties(hibernateProperties());
//		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		return entityManagerFactory;
//	}
	
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//		internalResourceViewResolver.setPrefix("/WEB-INF/JSPFiles/");
//		internalResourceViewResolver.setSuffix(".jsp");
//		internalResourceViewResolver.setViewClass(JstlView.class);
//		return internalResourceViewResolver;
//	}
	
	
}
