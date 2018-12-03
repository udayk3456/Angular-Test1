package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OrderType {
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="increment")
	private Integer id;
	@Column(name="order_type")
	private String orderType;

	public OrderType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "OrderType [id=" + id + ", orderType=" + orderType + "]";
	}
	
	
}
