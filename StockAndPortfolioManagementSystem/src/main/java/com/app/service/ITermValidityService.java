package com.app.service;

import java.util.List;

import com.app.model.TermValidity;

public interface ITermValidityService {
	Integer saveTermValidity(TermValidity termValidity);
	TermValidity getTermValidityById(int id);
	List<TermValidity> getAllTermValidities();
}
