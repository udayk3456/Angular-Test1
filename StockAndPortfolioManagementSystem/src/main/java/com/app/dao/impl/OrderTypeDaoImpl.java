package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderTypeDao;
import com.app.model.OrderType;
@Repository
public class OrderTypeDaoImpl implements IOrderTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public OrderType getOrderTypeById(int id) {
		return ht.get(OrderType.class, id);
	}

	@Override
	public List<OrderType> gellAllOrderTypes() {
		return ht.loadAll(OrderType.class);
	}

}
