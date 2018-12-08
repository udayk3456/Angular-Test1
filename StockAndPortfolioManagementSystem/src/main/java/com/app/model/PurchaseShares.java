package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchaseshares")
public class PurchaseShares {
	@Id
	@GeneratedValue(generator="ps")
	@GenericGenerator(name="ps",strategy="increment")
	@Column(name="ps_col")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cust_fk")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="comfk")
	private Company company;
	
	@Column(name="numberofpurchasedshares")
	private Integer numberOfPurchasedShares;
	
	@Column(name="totalcost")
	private Double totalCost;
	
	@ManyToOne
	@JoinColumn(name="tvfk")
	private TermValidity termValidity;
	
	@ManyToOne
	@JoinColumn(name="otfk")
	private OrderType orderType;

	public PurchaseShares() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	public Integer getNumberOfPurchasedShares() {
		return numberOfPurchasedShares;
	}

	public void setNumberOfPurchasedShares(Integer numberOfPurchasedShares) {
		this.numberOfPurchasedShares = numberOfPurchasedShares;
	}

	public TermValidity getTermValidity() {
		return termValidity;
	}

	public void setTermValidity(TermValidity termValidity) {
		this.termValidity = termValidity;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "PurchaseShares [id=" + id + ", customer=" + customer + ", company=" + company
				+ ", numberOfPurchasedShares=" + numberOfPurchasedShares + ", totalCost=" + totalCost
				+ ", termValidity=" + termValidity + ", orderType=" + orderType + "]";
	}

	
}
