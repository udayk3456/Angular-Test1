package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Agent;
import com.app.model.Company;
import com.app.model.Share;
import com.app.service.IAgentService;
import com.app.service.ICompanyService;
import com.app.service.IShareService;

/***
 * 
 * @author UDAY
 * 
 ***/

@Controller
@RequestMapping("/homepage/admin")
public class AdminController {
	@Autowired
	private ICompanyService companyService;
	@Autowired
	private IShareService shareService;
	@Autowired
	private IAgentService agentService;


	/***
	 * 
	 * AdminPage_HomePage 
	 * 
	 ***/
	@RequestMapping("/home")
	public String home() {
		return "AdminPage";
	}


	/***
	 * 
	 * Add Company data type 
	 * 
	 ***/
	//add company
	@RequestMapping("/addcompany")
	public String saveCompany(ModelMap map) {
		Company c=new Company();
		map.addAttribute("company",c);
		return "CompanyRegister";
	}
	//add company_2
	@RequestMapping(value="/insertcompany",method=RequestMethod.POST)
	public String insertCompany(@ModelAttribute Company company,ModelMap map) {
		companyService.saveCompany(company);
		String msg="company of symbol :'"+company.getCompanySymbol()+"' saved successfull";
		map.addAttribute("msg",msg);
		map.addAttribute("company",new Company());
		return "CompanyRegister";
	}


	/***
	 * 
	 * Companies data type 
	 * 
	 ***/
	//companies data
	@RequestMapping("/allcompanies")
	public String data(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyData";
	}


	/***
	 * 
	 * Delete company data type 
	 * 
	 ***/
	//delete company
	@RequestMapping("/deletecompany")
	public String delete(@ModelAttribute Company company,ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyDelete";
	}
	//delete company_2
	@RequestMapping("/delete")
	public String deleteCompany(@ModelAttribute Company company,ModelMap map) {
		companyService.deleteCompany(company.getId());
		map.addAttribute("msg","deleted successfully");
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyDelete";
	}


	/***
	 * 
	 * update company data type 
	 * 
	 ***/
	//update company
	@RequestMapping("/editcompanies")
	public String update(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyEdit";
	}
	//update company_2
	@RequestMapping("/updatecompany")
	public String updateCompany(@RequestParam Integer id,ModelMap map) {
		Company c=companyService.getCompanyById(id);
		map.addAttribute("company",c);
		return "CompanyUpdate";
	}
	//update company_3
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update_Company(@ModelAttribute Company company,ModelMap map) {
		companyService.updateCompany(company);
		String msg="company  :'"+company.getCompanyName()+"' updated successfull";
		map.addAttribute("msg",msg);
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "CompanyData";
	}


	/***
	 * 
	 * Add share data type 
	 * 
	 ***/
	//add share
	@RequestMapping("/addshare")
	public String addShare(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		map.addAttribute("share",new Share());
		return "ShareRegister";
	}
	//add share_2
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


	/***
	 * 
	 * Show all shares
	 * 
	 ***/
	//shares data
	@RequestMapping("/allshares")
	public String shareData(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}


	/***
	 * 
	 * update shares data type 
	 * 
	 ***/
	//update share
	@RequestMapping("/editshare")
	public String updateShare(ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		map.addAttribute("share",new Share());
		return "ShareEdit";
	}
	//update share_2
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
	//update share_3
	@RequestMapping("/shareupdate")
	public String shareUpdate(@ModelAttribute Share share,ModelMap map) {
		shareService.updateShare(share);
		String msg="Share updated successfull";
		map.addAttribute("msg",msg);
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}


	/***
	 * 
	 * Delete share type 
	 * 
	 ***/
	//delete share
	@RequestMapping("/deleteshare")
	public String deleteshare(@ModelAttribute Share share,ModelMap map) {
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareDelete";
	}
	//delete share_2
	@RequestMapping("/sharedelete")
	public String shareDelete(@ModelAttribute Share share,ModelMap map) {
		/*companyService.deleteCompany(company.getId());*/
		shareService.deleteShare(share.getId());
		map.addAttribute("msg","deleted successfully");
		List<Company> companies=companyService.getAllCompanies();
		map.addAttribute("companies",companies);
		return "ShareData";
	}


	/***
	 * 
	 * Agents data_approve type 
	 * 
	 ***/
	//Agents data_to validate
	@RequestMapping("/agentsapprovedata")
	public String agentToAcceptData(@ModelAttribute Agent agent,ModelMap map) {
		List<Agent> agents=agentService.getAgentsByStatus("NO");
		map.addAttribute("agents",agents);
		return "AdminAgentsData";
	}


	/***
	 * 
	 * Agents data_accept type 
	 * 
	 ***/
	//agents data to accept
	@RequestMapping(value="/agentsaccepteddata",method=RequestMethod.POST)
	public String agentAcceptedData(@ModelAttribute Agent agent,ModelMap map) {	
		if(agent.getStatus().equals("NO")) {
			List<Agent> agents=agentService.getAgentsByStatus("NO");
			map.addAttribute("agents",agents);
			return "AdminAgentsData";
		}
		else {
			agent.setStatus("APPROVED");
			agentService.updateAgent(agent);
			List<Agent> agents=agentService.getAgentsByStatus("APPROVED");
			map.addAttribute("agents",agents);
			return "AdminAgentsData2";
		}
	}
	//agents data accepted
	@RequestMapping("/agentadminacceptedagentsdata")
	public String adminAcceptedData(ModelMap map) {
		List<Agent> agents=agentService.getAgentsByStatus("APPROVED");
		map.addAttribute("agents",agents);
		return "AdminAgentsData2";
	}

	/***
	 * 
	 * Agents data_reject type 
	 * 
	 ***/
	//agents data to reject
	@RequestMapping(value="/agentsrejecteddata",method=RequestMethod.POST)
	public String agentRejectedData(@ModelAttribute Agent agent,ModelMap map) {
		if(agent.getStatus().equals("NO")) {
			List<Agent> agents=agentService.getAgentsByStatus("NO");
			map.addAttribute("agents",agents);
			return "AdminAgentsData";
		}
		else {
			agent.setStatus("REJECTED");
			agentService.updateAgent(agent);
			List<Agent> agents=agentService.getAgentsByStatus("REJECTED");
			map.addAttribute("agents",agents);
			return "AdminAgentsData2";
		}
	}
	//agents data rejected
	@RequestMapping("/agentadminrejectedagentsdata")
	public String adminRejectedData(ModelMap map) {
		List<Agent> agents=agentService.getAgentsByStatus("REJECTED");
		map.addAttribute("agents",agents);
		return "AdminAgentsData2";
	}
}
