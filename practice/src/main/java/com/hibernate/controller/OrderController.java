package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.domain.OrdersDTO;
import com.hibernate.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/saveOrder", method=RequestMethod.POST)
	public ResponseEntity<String> saveOrder(@RequestBody OrdersDTO ordersDTO){
		orderService.createOrder(ordersDTO);
		return new ResponseEntity<String>("create successfully",HttpStatus.OK);	// OK Accepted Found
	}
	
	@RequestMapping(value = "/getOrder", method=RequestMethod.GET)
	public ResponseEntity<OrdersDTO> getOrder(@RequestParam long id){
		OrdersDTO ordersDTO = orderService.findOrderById(id);
		return new ResponseEntity<OrdersDTO>(ordersDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllOrders", method=RequestMethod.GET)
	public ResponseEntity<List<OrdersDTO>> getAllOrders(@RequestParam int pageNumber, @RequestParam int pageSize){
		
		List<OrdersDTO> ordersDTOList = orderService.getAllOrders(pageNumber, pageSize);
		return new ResponseEntity<List<OrdersDTO>>(ordersDTOList,HttpStatus.OK);
	}

	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public ResponseEntity<String> test(){
		
		return new ResponseEntity<String>("Hi!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/test1", method=RequestMethod.GET)
	public String test1() {
		return "Hello World!";
	}
	
}
