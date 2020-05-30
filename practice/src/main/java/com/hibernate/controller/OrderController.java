package com.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<OrdersDTO> getOrder(@RequestBody long id){
		OrdersDTO ordersDTO = orderService.findOrderById(id);
		return new ResponseEntity<OrdersDTO>(ordersDTO,HttpStatus.OK);
	}

}
