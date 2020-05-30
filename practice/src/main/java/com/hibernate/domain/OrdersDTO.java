package com.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders", schema = "practiceDB")
public class OrdersDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="order_id")
	private String orderId;
	
//	@Column(name="order_detail")
	private String orderDetail;
	
	private String newColumn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getNewColumn() {
		return newColumn;
	}

	public void setNewColumn(String newColumn) {
		this.newColumn = newColumn;
	}
	
	
	
	
}
