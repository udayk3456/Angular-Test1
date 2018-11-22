package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Company;
import com.app.service.ICompanyService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ICompanyService companyService;
	
	@RequestMapping("/home")
	public String home() {
		return "AdminPage";
	}
	@RequestMapping("/addcompany")
	public String saveCompany(ModelMap map) {
		Company c=new Company();
		map.addAttribute("company",c);
		return "CompanyRegister";
	}
	@RequestMapping(value="/insertcompany",method=RequestMethod.POST)
	public String insertCompany(@ModelAttribute Company company,ModelMap map) {
		companyService.saveCompany(company);
		String msg="company of symbol :'"+company.getCompanySymbol()+"' saved successfull";
		map.addAttribute("msg",msg);
		map.addAttribute("company",new Company());
		return "CompanyRegister";
	}
	
	@RequestMapping("/allcompanies")
	public String data(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyData";
	}
	
	@RequestMapping("/deletecompany")
	public String delete(ModelMap map) {
		
		map.addAttribute("msg","deleted successfully");
		return null;
	}
	

}
