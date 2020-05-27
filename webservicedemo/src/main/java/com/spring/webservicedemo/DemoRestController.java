package com.spring.webservicedemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@RequestMapping(value="/demoGet", method=RequestMethod.GET)
	public ResponseEntity<String> getSomething(){
		return new ResponseEntity<String>("Hi Client!",HttpStatus.OK);
	}
	
	@RequestMapping(value="/demoPost", method=RequestMethod.POST)
	public ResponseEntity<String> postSomething(@RequestBody User user){
		
		return new ResponseEntity<String>(user.toString(),HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/demoPut", method=RequestMethod.PUT)
	public ResponseEntity<String> putSomething(){
		return new ResponseEntity<String>("demo",HttpStatus.OK);
	}
	
	@RequestMapping(value="/demoDelete", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteSomething(){
		return new ResponseEntity<String>("demo",HttpStatus.OK);
	}
	

}
