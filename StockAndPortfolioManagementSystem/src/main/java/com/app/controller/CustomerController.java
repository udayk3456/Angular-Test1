package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Agent;
import com.app.model.Company;
import com.app.service.IAgentService;
import com.app.service.ICompanyService;
import com.app.service.ICustomerService;
import com.app.service.IOrderTypeService;
import com.app.service.IShareService;
import com.app.service.ITermValidityService;

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
	@Autowired
	private ITermValidityService termValidityService;
	@Autowired
	private IOrderTypeService orderTypeService;
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IShareService shareService;
	
	private String customerName;


	@RequestMapping("/")
	public ModelAndView id(@RequestParam Integer id) {
		ModelAndView m=new ModelAndView();
		customerName=customerService.getCustomerById(id).getUserName();
		/*System.out.println(customerName);*/
		m.addObject("customername",customerName);
		m.setViewName("CustomerPage");
	    return m;	
	}
		
		/*@RequestMapping("/")
		class Inner{
			*//***
			 * 
			 *Custome_HomePage
			 *
			 **/
			@RequestMapping("/home")
			public String home(ModelMap map) {
				map.addAttribute("customername",customerName);
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
				map.addAttribute("customername",customerName);
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
				map.addAttribute("customername",customerName);
				return "CustomerViewAgentsData";
			}


			/***
			 * 
			 *PurchaseShares
			 *
			 **/
			@RequestMapping("/purchaseshares")
			public String purchaseShares(ModelMap map) {
				map.addAttribute("customername",customerName);
				return "CustomerPurchaseShares";
			}

			/**
			 * 
			 * SaleShares
			 * 
			 **/
		/*}
		return m;*/
	}


