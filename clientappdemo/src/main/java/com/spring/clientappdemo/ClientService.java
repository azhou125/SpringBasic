package com.spring.clientappdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class ClientService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Gson gson;
	
//	@PostConstruct
	public void clientMethod1() {
		String str = restTemplate.getForObject("http://localhost:8080/demoGet", String.class);
		System.out.println(str);
	}
	
	@PostConstruct
	public void clientMethod2() {
		User user = new User();
		user.setEmailAddress("ang@gmail.com");
		user.setPassword("123");
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("content-type", "application/json");
		
		
		HttpEntity<String> request = 
			      new HttpEntity<String>(gson.toJson(user), httpHeaders);
		
		String str = restTemplate.postForObject("http://localhost:8080/demoPost", request, String.class);
		System.out.println(str);
	}
	
	
}
