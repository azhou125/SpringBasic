package com.hibernate.practice.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;


@Configuration
public class HibernateConfiguration {
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Value("${jdbc.username}")
	private String userName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.format_sql}")
	private String formatSql;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public String getShowSql() {
		return showSql;
	}

	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}

	public String getFormatSql() {
		return formatSql;
	}

	public void setFormatSql(String formatSql) {
		this.formatSql = formatSql;
	}

	
	
	

}
