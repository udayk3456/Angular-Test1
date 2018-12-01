package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ITermValidityDao;
import com.app.model.TermValidity;
import com.app.service.ITermValidityService;

@Service
public class TermValidityServiceImpl implements ITermValidityService {
	@Autowired
	private ITermValidityDao dao;

	@Transactional
	public Integer saveTermValidity(TermValidity termValidity) {
		return dao.saveTermValidity(termValidity);
	}

	@Transactional(readOnly=true)
	public TermValidity getTermValidityById(int id) {
		return dao.getTermValidityById(id);
	}

	@Transactional(readOnly=true)
	public List<TermValidity> getAllTermValidities() {
		return dao.getAllTermValidities();
	}

}
