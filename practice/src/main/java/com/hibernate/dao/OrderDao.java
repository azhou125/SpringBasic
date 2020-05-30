package com.hibernate.dao;

import java.util.List;

import com.hibernate.domain.OrdersDTO;

public interface OrderDao {
	public void createOrder(OrdersDTO order);
	public OrdersDTO getOrder(long id);
	public List<OrdersDTO> getAllOrders(int pageNum, int pageSize);
	
}
