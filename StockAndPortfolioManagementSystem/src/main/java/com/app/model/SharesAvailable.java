package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shares_available_open")
public class SharesAvailable {
	@Id
	@GeneratedValue(generator="sa")
	@GenericGenerator(name="sa",strategy="increment")
	@Column(name="sa_pk")
	private int id;
	@Column(name="shares_available")
	private Integer sharesAvailable;
	
	public SharesAvailable() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSharesAvailable() {
		return sharesAvailable;
	}

	public void setSharesAvailable(Integer sharesAvailable) {
		this.sharesAvailable = sharesAvailable;
	}

	@Override
	public String toString() {
		return "SharesAvailable [id=" + id + ", sharesAvailable=" + sharesAvailable + "]";
	}
	
	
}
