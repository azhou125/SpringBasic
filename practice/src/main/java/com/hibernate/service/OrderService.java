package com.hibernate.service;

import com.hibernate.domain.OrdersDTO;

public interface OrderService {
	
	public void createOrder(OrdersDTO ordersDTO);
	public OrdersDTO findOrderById(long id);

}
