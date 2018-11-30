package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Company;
import com.app.model.Customer;
import com.app.service.ICompanyService;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/homepage/agent")
public class AgentController {
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping("/home")
	public String home() {
		return "AgentPage";
	}

	@RequestMapping("/viewcompanies")
	public String companiesData(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "AgentViewCompaniesData";
	}
	
	@RequestMapping("/viewcustomers")
	public String customersData(ModelMap map) {
		List<Customer> customers=customerService.getAllCustomers();
		map.addAttribute("customers",customers);
		return "AgentViewCustomersData";
	}

}
