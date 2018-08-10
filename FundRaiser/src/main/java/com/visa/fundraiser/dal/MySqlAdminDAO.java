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
	
	public boolean validateLogin(String email, String pass) {
		Query q= em.createQuery("select a from Admin a where a.emailid like :email")
				.setParameter("email", email);		
		Admin a;
		
		try {
		a=(Admin) q.getSingleResult();
		}
		catch(Exception e) {
			return false;
		}
		//System.out.println("[From within validate login, database = "+a.getPassword()+" and passwd value is "+pass);

		if(a.getPassword().equals(pass)) {
			System.out.println("Went through true");

			return true;
		}
		else
		return false; 
	}
	
	@Override
	public List<Admin> findAll(){
		
		Query q = em.createQuery("select a from Admin a");
		List<Admin> all = q.getResultList();
		return all;
	}
	
	@Override
	public Admin findOne(int id) {
		Admin a = em.find(Admin.class, id);		
		return a;
		
	}
	/* (non-Javadoc)
	 * @see com.visa.fundraiser.dal.AdminDAO#updateAdmin(com.visa.fundraiser.domain.Admin)
	 */
	@Override
	public Admin updateAdmin(Admin a) {
		Admin A= em.merge(a);
		return A;
	}
	

}
