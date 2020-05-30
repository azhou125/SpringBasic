package com.hibernate.service;

import java.util.List;

import com.hibernate.domain.OrdersDTO;

public interface OrderService {
	
	public void createOrder(OrdersDTO ordersDTO);
	public OrdersDTO findOrderById(long id);
	public List<OrdersDTO> getAllOrders(int pageNum, int pageSize);

}
