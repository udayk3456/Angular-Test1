package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_shares")
public class PurchaseShares {
	@Id
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id",strategy="increment")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cust_fk")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="com_fk,unique=true")
	private Company company;
	
	@Column(name="no.ofshares")
	private Integer numberOfShares;
	
	@ManyToOne
	@JoinColumn(name="tv_fk")
	private TermValidity termValidity;
	
	@ManyToOne
	@JoinColumn(name="ot_fk")
	private OrderType orderType;

}
