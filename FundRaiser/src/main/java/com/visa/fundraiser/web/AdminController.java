package com.visa.fundraiser.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.fundraiser.domain.Admin;
import com.visa.fundraiser.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	

	@RequestMapping(value="/validatelogin",method=RequestMethod.GET)
	public void validation(Map<String,Object> requestAttributes, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		
		if(service.validateLogin(email,password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			response.sendRedirect("loggedin.jsp");
			
		}
	
		else {
			RequestDispatcher rd = request.getRequestDispatcher("adminlogin.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
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
	
	@RequestMapping(value="/editadmincontroller/{id}",method=RequestMethod.GET)
	public String editadmin(Map<String,Object> requestAttributes, @PathVariable("id")int id) {
		Admin a=service.findOne(id);
		requestAttributes.put("a",a);
		return "editadmin";
	}
	
	
	@RequestMapping(value="/updateadmin",method=RequestMethod.GET)
	public String updateAdmin(Map<String,Object> requestAttributes, @ModelAttribute("SpringWeb")Admin a){
		a.setDate(new Date(System.currentTimeMillis()));
		service.updateAdmin(a);
		return "success";	
	}
	

	
}