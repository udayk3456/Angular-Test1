package com.app.service;

import java.util.List;

import com.app.model.OrderType;

public interface IOrderTypeService {
	OrderType getOrderTypeById(int id);
	List<OrderType> gellAllOrderTypes();
}
