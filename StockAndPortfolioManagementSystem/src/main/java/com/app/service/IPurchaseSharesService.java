package com.app.service;

import java.util.List;

import com.app.model.PurchaseShares;

public interface IPurchaseSharesService {
	Integer savePurchaseShares(PurchaseShares pshares);
	void updatePurchaseShares(PurchaseShares pshares);
	PurchaseShares getPurchaseSharesById(int id);
	List<PurchaseShares> getAllPurchaseShares();
}
