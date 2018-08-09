package com.visa.fundraiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.fundraiser.dal.AdminDAO;
import com.visa.fundraiser.domain.Admin;

@Component("service")
@Transactional
public class AdminService {
	
	AdminDAO dao;
	
	@Autowired
	public void setDao(AdminDAO dao) {
		this.dao = dao;
		System.out.println("[From within service. Get object of DAO]");
	}
	
	public Admin addNew(Admin a) {
		return dao.addNew(a);
	}
	
	public List<Admin> findAll(){
		return dao.findAll();
	}
	
	public Admin updateAdmin(Admin a) {
		return dao.updateAdmin(a);
	}
	
}
