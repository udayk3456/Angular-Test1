package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Share {
	@Id
	private Integer id;
	private Integer sharePrice;
	private Integer numberOfShares;
	
	public Share() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(Integer sharePrice) {
		this.sharePrice = sharePrice;
	}

	public Integer getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(Integer numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	@Override
	public String toString() {
		return "Share [id=" + id + ", sharePrice=" + sharePrice + ", numberOfShares=" + numberOfShares + "]";
	}

}
