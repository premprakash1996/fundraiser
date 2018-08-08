package com.visa.fundraiser.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.visa.fundraiser.domain.Admin;



@Component
@Transactional
public class MySqlAdminDAO implements AdminDAO {
	
	@Autowired
	EntityManager em;

	
	/* (non-Javadoc)
	 * @see com.visa.fundraiser.dal.AdminDAO#setEm(javax.persistence.EntityManager)
	 */
	@Override
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/* (non-Javadoc)
	 * @see com.visa.fundraiser.dal.AdminDAO#addNew(com.visa.fundraiser.domain.Admin)
	 */
	@Override
	public Admin addNew(Admin a){
		em.persist(a);
		return a;
	}
	
	@Override
	public List<Admin> findAll(){
		
		Query q = em.createQuery("select a from Admin a");
		List<Admin> all = q.getResultList();
		return all;
	}
	
	/* (non-Javadoc)
	 * @see com.visa.fundraiser.dal.AdminDAO#updateAdmin(com.visa.fundraiser.domain.Admin)
	 */
	@Override
	public Admin updateAdmin(Admin a) {
		em.merge(a);
		return a;
	}
	

}
