package com.hibernate.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.domain.OrdersDTO;

@Repository("ordersDAO")
@Transactional
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurretSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createOrder(OrdersDTO order) {
		getCurretSession().saveOrUpdate(order);
	}

	@Override
	public OrdersDTO getOrder(long id) {
		return (OrdersDTO) getCurretSession().createQuery("FROM OrdersDTO where order_id = '" + id + "'").getResultList().get(0);
		
	}
	
	
}


	
