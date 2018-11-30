package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Agent;
import com.app.model.Company;
import com.app.service.IAgentService;
import com.app.service.ICompanyService;

/***
 * 
 *@author uday
 *
 **/
@Controller
@RequestMapping("/homepage/customer")
public class CustomerController {
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IAgentService agentService;
	
	
	/***
	 * 
	 *Custome_HomePage
	 *
	 **/
	@RequestMapping("/home")
	public String home() {
		return "CustomerPage";
	}
	
	
	/***
	 * 
	 *ViewCompanies
	 *
	 **/
	@RequestMapping("/viewcompanies")
	public String companiesData(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CustomerViewCompaniesData";
	}
	
	
	/***
	 * 
	 *ViewAgents
	 *
	 **/
	@RequestMapping("/viewagents")
	public String agentsData(ModelMap map) {
		List<Agent> agents=agentService.getAllAgents();
		map.addAttribute("agents",agents);
		return "CustomerViewAgentsData";
	}
	
	
	/***
	 * 
	 *PurchaseShares
	 *
	 **/
	@RequestMapping("/purchaseshares")
	public String purchaseShares(ModelMap map) {
		
		
		return "CustomerPurchaseShares";
	}
	
	
	
}

