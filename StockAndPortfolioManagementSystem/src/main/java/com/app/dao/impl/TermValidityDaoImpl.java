package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ITermValidityDao;
import com.app.model.TermValidity;

@Repository
public class TermValidityDaoImpl implements ITermValidityDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveTermValidity(TermValidity termValidity) {
		return (Integer) ht.save(termValidity);
	}

	@Override
	public TermValidity getTermValidityById(int id) {
		return ht.get(TermValidity.class, id);
	}

	@Override
	public List<TermValidity> getAllTermValidities() {
		return ht.loadAll(TermValidity.class);
	}

}
