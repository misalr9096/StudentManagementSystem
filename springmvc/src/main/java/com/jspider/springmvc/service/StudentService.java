package com.jspider.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public StudentPOJO addStudent(String name, String email, long contact, String address) {

		StudentPOJO pojo = repository.addStudent(name, email, contact, address);

		return pojo;
	}

	public StudentPOJO searchStudent(int id) {

		StudentPOJO pojo = repository.searchStudent(id);

		return pojo;
	}

	public List<StudentPOJO> findAllStudents() {

		List<StudentPOJO> students = repository.findAllStudents();

		return students;
	}

	public StudentPOJO deleteStudent(int id) {
		
		StudentPOJO pojo=repository.deleteStudent(id);

		return pojo;
	}

	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
			
		StudentPOJO pojo=repository.updateStudent(id,name,email,contact,address);
		

		return pojo;
	}

	public List<StudentPOJO> searchStudentByContact(long parseLong) {
		
		List<StudentPOJO> student=repository.searchStudentByContact(parseLong);
		return student;
	}

	public List<StudentPOJO> searchStudentByEmail(String value) {
		List<StudentPOJO> student=repository.searchStudentByEmail(value);
		return student;
	}

	public List<StudentPOJO> searchStudentByName(String value) {
		List<StudentPOJO> student=repository.searchStudentByName(value);
		return student;
	}
	
	
//	public List<StudentPOJO> searchStudent(String name,String email,Long contact){
//
//		return repository.searchStudent(name, email,contact);
//		
//	}

}
