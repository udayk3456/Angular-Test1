package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseSharesDao;
import com.app.model.PurchaseShares;
import com.app.service.IPurchaseSharesService;
@Service
public class PurchaseSharesServiceImpl implements IPurchaseSharesService {
	@Autowired
	private IPurchaseSharesDao dao;

	@Transactional
	public Integer savePurchaseShares(PurchaseShares pshares) {
		return dao.savePurchaseShares(pshares);
	}

	@Transactional(readOnly=true)
	public PurchaseShares getPurchaseSharesById(int id) {
		return dao.getPurchaseSharesById(id);
	}

	@Transactional(readOnly=true)
	public List<PurchaseShares> getAllPurchaseShares() {
		return dao.getAllPurchaseShares();
	}

}
