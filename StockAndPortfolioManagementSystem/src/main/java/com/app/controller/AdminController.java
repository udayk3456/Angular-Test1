package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Company;
import com.app.model.Share;
import com.app.service.ICompanyService;
import com.app.service.IShareService;

@Controller
@RequestMapping("/homepage/admin")
public class AdminController {
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IShareService shareService;
	
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
	public String delete(@ModelAttribute Company company,ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyDelete";
	}
	
	@RequestMapping("/delete")
	public String deleteCompany(@ModelAttribute Company company,ModelMap map) {
		companyService.deleteCompany(company.getId());
		map.addAttribute("msg","deleted successfully");
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyDelete";
	}
	
	@RequestMapping("/editcompanies")
	public String update(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyEdit";
	}
	
	@RequestMapping("/updatecompany")
	public String updateCompany(@RequestParam Integer id,ModelMap map) {
		Company c=companyService.getCompanyById(id);
		map.addAttribute("company",c);
		return "CompanyUpdate";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update_Company(@ModelAttribute Company company,ModelMap map) {
		companyService.updateCompany(company);
		String msg="company  :'"+company.getCompanyName()+"' updated successfull";
		map.addAttribute("msg",msg);
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyData";
	}
	
	@RequestMapping("/addshare")
	public String addShare(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		map.addAttribute("share",new Share());
		return "ShareRegister";
	}
	
	@RequestMapping(value="/insertshare",method=RequestMethod.POST)
	public String insertShare(@ModelAttribute Share share,ModelMap map) {
		shareService.updateShare(share);
		String msg="Share updated successfull";
		map.addAttribute("msg",msg);
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		map.addAttribute("share",new Share());
		return "ShareRegister";
	}
	
	@RequestMapping("/allshares")
	public String shareData(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}
	
	@RequestMapping("/editshare")
	public String updateShare(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		map.addAttribute("share",new Share());
		return "ShareEdit";
	}
	@RequestMapping("/updateshare")
	public String updateShare(@ModelAttribute Share share,ModelMap map) {
		Share s=shareService.getShareById(share.getId());
		Company c=companyService.getCompanyById(share.getId());
		String symbol=c.getCompanySymbol();
		map.addAttribute("company",symbol);
		map.addAttribute("sharePrice",s.getSharePrice());
		map.addAttribute("share",s);
		return "ShareUpdate";
	}
	@RequestMapping("/shareupdate")
	public String shareUpdate(@ModelAttribute Share share,ModelMap map) {
		shareService.updateShare(share);
		String msg="Share updated successfull";
		map.addAttribute("msg",msg);
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}
	@RequestMapping("/deleteshare")
	public String deleteshare(@ModelAttribute Share share,ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareDelete";
	}
	@RequestMapping("/sharedelete")
	public String shareDelete(@ModelAttribute Share share,ModelMap map) {
		/*companyService.deleteCompany(company.getId());*/
		shareService.deleteShare(share.getId());
		map.addAttribute("msg","deleted successfully");
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}
	
	
}
