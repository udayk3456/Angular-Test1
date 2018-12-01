package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.model.TermValidity;
import com.app.service.ITermValidityService;

@Controller
public class TermValidityController {
	@Autowired
	private ITermValidityService service;
	
	public void save() {
		TermValidity t=new TermValidity();
		t.setTermValidity("DayOrder");
		service.saveTermValidity(t);
	}

}
