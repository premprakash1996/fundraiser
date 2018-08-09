package com.visa.fundraiser.web;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.fundraiser.domain.Admin;
import com.visa.fundraiser.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	

	@RequestMapping(value="/validatelogin",method=RequestMethod.GET)
	public String validation(Map<String,Object> requestAttributes) {
		return "loggedin";
	}
	
	@RequestMapping(value="/addadmin",method=RequestMethod.GET)
	public String addAdmin(Map<String,Object> requestAttributes, @ModelAttribute("SpringWeb")Admin a ){
		a.setDate(new Date(System.currentTimeMillis()));
		service.addNew(a);
		return "success";
	}
	
	@RequestMapping(value="/admins",method=RequestMethod.GET)
	public String adminList(Map<String,Object> requestAttributes){
		List<Admin> all = service.findAll();
		requestAttributes.put("admins", all);
		return "showadmins";	
	}
	
	
	
	
/*	@RequestMapping(value="/admins/{a}",method=RequestMethod.GET)
	public String updateAdmin(Map<String,Object> requestAttributes){
		List<Admin> all = service.findAll();
		requestAttributes.put("admins", all);
		return "updateAdmin";	
	}
	*/

	
}