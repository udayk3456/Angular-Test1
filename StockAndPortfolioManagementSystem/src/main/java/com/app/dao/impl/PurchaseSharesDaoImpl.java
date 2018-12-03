package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseSharesDao;
import com.app.model.PurchaseShares;
@Repository
public class PurchaseSharesDaoImpl implements IPurchaseSharesDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseShares(PurchaseShares pshares) {
		return (Integer) ht.save(pshares);
	}

	@Override
	public PurchaseShares getPurchaseSharesById(int id) {
		return ht.get(PurchaseShares.class, id);
	}

	@Override
	public List<PurchaseShares> getAllPurchaseShares() {
		return ht.loadAll(PurchaseShares.class);
	}

}
