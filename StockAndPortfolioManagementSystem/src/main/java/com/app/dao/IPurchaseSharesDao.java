package com.app.dao;

import java.util.List;

import com.app.model.PurchaseShares;

public interface IPurchaseSharesDao {
	Integer savePurchaseShares(PurchaseShares pshares);
	void updatePurchaseShares(PurchaseShares pshares);
	PurchaseShares getPurchaseSharesById(int id);
	List<PurchaseShares> getAllPurchaseShares();
}
