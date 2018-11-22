package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Agent;
import com.app.service.IAgentService;

@Controller
@RequestMapping("/agent")
public class AgentController {
	@Autowired
	private IAgentService service;
	
	//login
	@RequestMapping("/login")
	public String login(ModelMap map) {
		
		//map.addAttribute("agent",new Agent());
		return "AgentLogin";
	}
	//register
	@RequestMapping("/register")
	public String show(ModelMap map) {
		map.addAttribute("agent",new Agent());
		return "AgentRegister";
	}
	

}
