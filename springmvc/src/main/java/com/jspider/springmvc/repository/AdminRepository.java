package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.AdminPOJO;

@Repository
public class AdminRepository {


	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static javax.persistence.Query query;

	private static void openConnection() {

		factory = Persistence.createEntityManagerFactory("mvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}

		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}

	}
	
	public AdminPOJO getAdmin() {
		openConnection();
		transaction.begin();
		
		String jpql="from AdminPOJO";
		
		Query query=manager.createQuery(jpql);
		
		
		List<AdminPOJO> resultList = query.getResultList();
		
		if(resultList.isEmpty() ==false) {
			for(AdminPOJO pojo : resultList) {
				transaction.commit();
				closeConnection();
				return pojo;
			}
		}
		
		
		
		transaction.commit();
		closeConnection();
		
		return null;
	}

	public AdminPOJO createAccount(String username, String password) {
		
		openConnection();
		transaction.begin();
		
		AdminPOJO pojo=new AdminPOJO();
		pojo.setPassword(password);
		pojo.setUsername(username);

		manager.persist(pojo);
		transaction.commit();
		closeConnection();

		return pojo;
	}

	public AdminPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		String jpql="from AdminPOJO where username = '"+username+"' and password = '"+password+"'";
		Query query=manager.createQuery(jpql);
		List<AdminPOJO> resultList = query.getResultList();
		
		if(resultList.isEmpty() ==false) {
			for(AdminPOJO pojo : resultList) {
				transaction.commit();
				closeConnection();
				return pojo;
			}
		}
	
		transaction.commit();
		closeConnection();
		return null;
	}

}
