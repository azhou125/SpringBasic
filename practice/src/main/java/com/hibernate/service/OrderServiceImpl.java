package com.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.OrderDao;
import com.hibernate.dao.OrderDaoImpl;
import com.hibernate.domain.OrdersDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDaoImpl orderDao;

	@Override
	public void createOrder(OrdersDTO ordersDTO) {
		orderDao.createOrder(ordersDTO);
	}

	@Override
	public OrdersDTO findOrderById(long id) {
		return orderDao.getOrder(id);
	}

	@Override
	public List<OrdersDTO> getAllOrders(int pageNum, int pageSize) {
		return orderDao.getAllOrders(pageNum, pageSize);
	}

}
