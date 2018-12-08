package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Agent;
import com.app.model.Company;
import com.app.model.Customer;
import com.app.model.PurchaseShares;
import com.app.service.IAgentService;
import com.app.service.ICompanyService;
import com.app.service.ICustomerService;
import com.app.service.IOrderTypeService;
import com.app.service.IPurchaseSharesService;
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
	@Autowired
	private IPurchaseSharesService purchaseSharesService;
	
	private Customer customer;


	@RequestMapping("/")
	public ModelAndView id(@RequestParam Integer id) {
		ModelAndView m=new ModelAndView();
		customer=customerService.getCustomerById(id);
		m.addObject("customer",customer);
		m.setViewName("CustomerPage");
	    return m;	
	}
		
		/***
			 * 
			 *Custome_HomePage
			 *
			 **/
			@RequestMapping("/home")
			public String home(ModelMap map) {
				map.addAttribute("customer",customer);
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
				map.addAttribute("customer",customer);
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
				List<Agent> agents=agentService.getAgentsByStatus("APPROVED");
				map.addAttribute("agents",agents);
				map.addAttribute("customer",customer);
				return "CustomerViewAgentsData";
			}


			/***
			 * 
			 *PurchaseShares
			 *
			 **/
			@RequestMapping("/purchaseshares")
			public String purchaseShares(ModelMap map) {
				List<Customer> customers=new ArrayList<>();
				customers.add(customer);
				map.addAttribute("customers",customers);
				map.addAttribute("companies",companyService.getAllCompanies());
				map.addAttribute("termvalidity",termValidityService.getAllTermValidities());
				map.addAttribute("ordertype",orderTypeService.gellAllOrderTypes());
				map.addAttribute("purchase",new PurchaseShares());
				map.addAttribute("customer",customer);
				return "CustomerPurchaseShares";
			}
			@RequestMapping(value="/purchasesave",method=RequestMethod.POST)
			public String savePurchaseShares(@ModelAttribute PurchaseShares purchase,ModelMap map) {
				int id=purchaseSharesService.savePurchaseShares(purchase);
				map.addAttribute("msg","purchase '"+id+"' saved successfully");
				List<Customer> customers=new ArrayList<>();
				customers.add(customer);
				map.addAttribute("customers",customers);
				map.addAttribute("companies",companyService.getAllCompanies());
				map.addAttribute("termvalidity",termValidityService.getAllTermValidities());
				map.addAttribute("ordertype",orderTypeService.gellAllOrderTypes());
				map.addAttribute("purchase",new PurchaseShares());
				map.addAttribute("customer",customer);
				return "CustomerPurchaseShares";
			}

			/**
			 * 
			 * SaleShares
			 * 
			 **/
			
			
			
	}


