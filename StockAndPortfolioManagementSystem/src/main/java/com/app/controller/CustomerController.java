package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@RequestMapping("/register")
	private String show(ModelMap map) {
		map.addAttribute("customer",new Customer());
		return "CustomerRegister";
	}

}
