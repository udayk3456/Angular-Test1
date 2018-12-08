package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sale_shares")
public class SaleShares {
	@Id
	@GeneratedValue(generator="ss")
	@GenericGenerator(name="ss",strategy="increment")
	private Integer id;
	
	
}
