package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderTypeDao;
import com.app.model.OrderType;
import com.app.service.IOrderTypeService;
@Service
public class OrderTypeServiceImpl implements IOrderTypeService {
	@Autowired
	private IOrderTypeDao dao;

	@Transactional(readOnly=true)
	public OrderType getOrderTypeById(int id) {
		return dao.getOrderTypeById(id);
	}

	@Transactional(readOnly=true)
	public List<OrderType> gellAllOrderTypes() {
		return dao.gellAllOrderTypes();
	}

}
