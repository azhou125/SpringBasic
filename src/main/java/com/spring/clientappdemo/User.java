package com.spring.clientappdemo;

public class User {

	private String emailAddress;
	private String password;
	
	public User() {}
	
	
	
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + "]";
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
