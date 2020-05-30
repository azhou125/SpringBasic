package com.hibernate.dao;

import com.hibernate.domain.OrdersDTO;

public interface OrderDao {
	public void createOrder(OrdersDTO order);
	public OrdersDTO getOrder(long id);
	
}
