package com.jspider.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvc.pojo.StudentPOJO;
import com.jspider.springmvc.service.StudentService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class StudentContoller {

	@Autowired
	StudentService service;

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@GetMapping("/add")
	public String add(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		return "Add";
	}

	@GetMapping("/delete")
	public String delete(ModelMap map) {

		List<StudentPOJO> students = service.findAllStudents();

		if (!students.isEmpty()) {
			map.addAttribute("students", students);
			return "Delete";
		}

		map.addAttribute("message", "Student Data Not Found..!");
		return "Delete";
	}
	
	@PostMapping("/delete")
	public String deleteStudent(@RequestParam int id,ModelMap map) {
		
		StudentPOJO pojo=service.deleteStudent(id);
		List<StudentPOJO> students = service.findAllStudents();
		
		if(pojo != null) {
			map.addAttribute("message", "Student Data Deleted Successfully..!");
			map.addAttribute("students", students);
			return "Delete";
		
		}
		map.addAttribute("message", "Student Data Not Found..!");
		map.addAttribute("students", students);
		return "Delete";
		
	}
	
	@GetMapping("/update")
	public String update(ModelMap map) {
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		return "Update";
	}

	@GetMapping("/search")
	public String search() {
		return "Search";
	}

	@PostMapping("/search")
	public String searchStudent(@RequestParam String select, @RequestParam String value,ModelMap map) {

		System.out.println(select);
		System.out.println(value);
		if(select.equals("1")) {
			
			StudentPOJO pojo = service.searchStudent(Integer.parseInt(value));
			
			if (pojo != null) {

				map.addAttribute("result", pojo);
				map.addAttribute("message", "Stundent Data Found..!");

				return "Search";
			}
			
		}else if(select.equals("2")) {
			
			List<StudentPOJO> student=service.searchStudentByName(value);
			
			
			if (student != null) {

				map.addAttribute("students", student);
				map.addAttribute("message", "Stundent Data Found..!");

				return "Search";
			}
			
			
			
		}else if(select.equals("3")) {
			
			List<StudentPOJO> student=service.searchStudentByEmail(value);
			
			if (student != null) {

				map.addAttribute("students", student);
				map.addAttribute("message", "Stundent Data Found..!");

				return "Search";
			}
			
		}else if(select.equals("4")) {
			
			List<StudentPOJO> student=service.searchStudentByContact(Long.parseLong(value));
			
			if (student != null) {

				map.addAttribute("students", student);
				map.addAttribute("message", "Stundent Data Found..!");

				return "Search";
			}
		}

		
		map.addAttribute("message", "Stundent Data Not Found..!");

		return "Search";
	}

	
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String address, ModelMap map) {

		StudentPOJO pojo = service.addStudent(name, email, contact, address);
		List<StudentPOJO> students = service.findAllStudents();
		
		// Success
		if (pojo != null) {
			map.addAttribute("message", "Student Added Successfully..!");
			map.addAttribute("students", students);
			return "Add";
		}

		map.addAttribute("message", "Student Not Added...!");
		map.addAttribute("students", students);
		return "Add";
	}

	@PostMapping("/update")
	public String updateStudent(@RequestParam int id,ModelMap map) {
		
		StudentPOJO pojo = service.searchStudent(id);
		List<StudentPOJO> students = service.findAllStudents();

		if (pojo != null) {
			map.addAttribute("result", pojo);
			return "Update";
		}
		map.addAttribute("message", "Stundent Data Not Found..!");
		map.addAttribute("students", students);
		return "Update";
		
	}
	
	@PostMapping("/updateStudent")
	public String updateStudentData(@RequestParam int id,
									@RequestParam String name,
									@RequestParam String email,
									@RequestParam long contact,
									@RequestParam String address,
									ModelMap map
									) {
	
		
	StudentPOJO pojo=service.updateStudent(id,name,email,contact,address);
	List<StudentPOJO> students = service.findAllStudents();
	
	if(pojo != null) {
		map.addAttribute("message", "Stundent Data Updated..!");
		map.addAttribute("students", students);
		return "Update";
	}
	
	map.addAttribute("message", "Stundent Data Not Updated..!");
	map.addAttribute("students", students);
	return "update";
	}
}
