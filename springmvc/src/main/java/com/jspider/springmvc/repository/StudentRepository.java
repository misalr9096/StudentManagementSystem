package com.jspider.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.mysql.cj.Query;

@Repository
public class StudentRepository {

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

	public StudentPOJO addStudent(String name, String email, long contact, String address) {
		openConnection();
		transaction.begin();

		StudentPOJO pojo = new StudentPOJO();
		pojo.setEmail(email);
		pojo.setName(name);
		pojo.setAddress(address);
		pojo.setContact(contact);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();

		return pojo;
	}

	public StudentPOJO searchStudent(int id) {

		openConnection();
		transaction.begin();

		StudentPOJO pojo = manager.find(StudentPOJO.class, id);

		transaction.commit();
		closeConnection();

		return pojo;
	}

	public List<StudentPOJO> findAllStudents() {

		openConnection();
		transaction.begin();
		String jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<StudentPOJO> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
	}

	public StudentPOJO deleteStudent(int id) {

		openConnection();
		transaction.begin();

		StudentPOJO pojo = manager.find(StudentPOJO.class, id);

		if (pojo != null) {
			manager.remove(pojo);
		}
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
		openConnection();
		transaction.begin();

		StudentPOJO pojo = manager.find(StudentPOJO.class, id);

		pojo.setAddress(address);
		pojo.setEmail(email);
		pojo.setName(name);
		pojo.setContact(contact);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();

		return pojo;
	}

	public List<StudentPOJO> searchStudentByContact(long parseLong) {
		openConnection();
		transaction.begin();
		String query = "Select p from StudentPOJO p where p.contact = :n ";
		TypedQuery<StudentPOJO> query2 = manager.createQuery(query, StudentPOJO.class);
		query2.setParameter("n", parseLong);

		List<StudentPOJO> students = query2.getResultList();

		transaction.commit();
		closeConnection();

		return students;
	}

	public List<StudentPOJO> searchStudentByEmail(String value) {
		openConnection();
		transaction.begin();
		String query = "Select p from StudentPOJO p where p.email =" + " :n ";
		TypedQuery<StudentPOJO> query2 = manager.createQuery(query, StudentPOJO.class);
		query2.setParameter("n", value);

		List<StudentPOJO> students = query2.getResultList();

		transaction.commit();
		closeConnection();

		return students;

	}

	public List<StudentPOJO> searchStudentByName(String value) {

		openConnection();
		transaction.begin();
		String query = "Select p from StudentPOJO p where p.name = :n ";
		TypedQuery<StudentPOJO> query2 = manager.createQuery(query, StudentPOJO.class);
		query2.setParameter("n", value);

		List<StudentPOJO> students = query2.getResultList();

		transaction.commit();
		closeConnection();

		return students;
	}

//	public List<StudentPOJO> searchStudent(String name, String email, Long contact) {
//		openConnection();
//		transaction.begin();
//		
//		String query = "Select p from StudentPOJO p where  ";
//		StringBuffer stringBuffer = new StringBuffer(query);
//
//		if (name != null && !name.isEmpty()) {
//			stringBuffer.append("p.name = :n ");
//		} else if (email != null && !email.isEmpty()) {
//			stringBuffer.append("p.email = :n ");
//		} else if (contact != null) {
//			stringBuffer.append("p.contact = :n ");
//		}
//
//		
//		TypedQuery<StudentPOJO> query2 = manager.createQuery(query, StudentPOJO.class);
//
//		if(name != null && !name.isEmpty()) {
//			query2.setParameter("n", name);
//		}else if(email != null && !email.isEmpty()) {
//			query2.setParameter("n", email);
//		}else if(contact!=null) {
//			query2.setParameter("n", contact);
//		}
//		
//		List<StudentPOJO> resultList = query2.getResultList();
//		
//		transaction.commit();
//		closeConnection();
//		return resultList;
//	}
}
