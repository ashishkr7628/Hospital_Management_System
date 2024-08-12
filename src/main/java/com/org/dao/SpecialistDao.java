package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Specialist;
@Repository
public class SpecialistDao {
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("karthik");
	

	  public void insertAndUpdateSpecialist(Specialist specialist) {
		  
		  EntityManager em = emf.createEntityManager();		 
		  
		  EntityTransaction et = em.getTransaction();
		  
		  et.begin();
		  
		  em.merge(specialist);
		  
		  et.commit();
		  
	
		  
	  }
	  
	public Specialist fetchSpecialistById(int id) {
			 
		EntityManager em = emf.createEntityManager();		 
		  
		  EntityTransaction et = em.getTransaction();
		
		return em.find(Specialist.class,id);
				
	}
	
	
	public List<Specialist> fetchAll(){
		EntityManager em = emf.createEntityManager();		 
		  
		  EntityTransaction et = em.getTransaction();
		  
		  Query query = em.createQuery("select d from Specialist d ");
		List<Specialist> list= query.getResultList();
		
		return list;
	}
	
	
	public List<Specialist> verifySpecialistByEmailAndPassword(String email, String password) {
		EntityManager em= emf.createEntityManager(); 
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createQuery("select d from Specialist d where d.email=?1 and d.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Specialist> list = query.getResultList();
	
		
		return list;
	}
	public boolean deleteSpecialistById(int id) {
		EntityManager em= emf.createEntityManager(); 
		EntityTransaction et = em.getTransaction();
		
		Specialist specialist =  em.find(Specialist.class, id);
		
		if(specialist !=null) {
			et.begin();
			em.remove(specialist);
			et.commit();
			return true;
		}
		return false;
	}
	


}
