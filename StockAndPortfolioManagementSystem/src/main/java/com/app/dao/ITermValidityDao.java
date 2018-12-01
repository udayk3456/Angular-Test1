package com.app.dao;

import java.util.List;

import com.app.model.TermValidity;

public interface ITermValidityDao {

	Integer saveTermValidity(TermValidity termValidity);
	TermValidity getTermValidityById(int id);
	List<TermValidity> getAllTermValidities();
}
