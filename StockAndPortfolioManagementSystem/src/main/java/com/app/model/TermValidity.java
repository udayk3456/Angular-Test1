package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TermValidity {
		@Id
		@GeneratedValue(generator="tv")
		@GenericGenerator(name="tv",strategy="increment")
		private Integer id;
		
		@Column(name="term_validity")
		private String termValidity;
		
		public TermValidity() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTermValidity() {
			return termValidity;
		}

		public void setTermValidity(String termValidity) {
			this.termValidity = termValidity;
		}

		@Override
		public String toString() {
			return "TermValidity [id=" + id + ", termValidity=" + termValidity + "]";
		}
		
		

}
