package com.app.dao;

import java.util.List;

import com.app.model.OrderType;

public interface IOrderTypeDao {

	OrderType getOrderTypeById(int id);
	List<OrderType> gellAllOrderTypes();
}
