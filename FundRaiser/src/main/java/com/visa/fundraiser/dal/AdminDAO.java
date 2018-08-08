package com.visa.fundraiser.dal;

import java.util.List;

import javax.persistence.EntityManager;

import com.visa.fundraiser.domain.Admin;

public interface AdminDAO {

	void setEm(EntityManager em);

	Admin addNew(Admin a);

	List<Admin> findAll();

	Admin updateAdmin(Admin a);

}