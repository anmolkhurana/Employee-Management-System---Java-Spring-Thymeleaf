package com.management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.entity.Employee;
import com.management.service.EmployeeService;

@Controller
public class EmpController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> empList = service.getAllEmployees();
		m.addAttribute("emp", empList);
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String getAddEmpForm() {
		return "add_emp";
	}
	
	@PostMapping("/createEmployee")
	public String createEmployee(@ModelAttribute Employee e, HttpSession session) {
		service.createEmployee(e);
		session.setAttribute("message","Employee created successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = service.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit";
	}
	
	@PostMapping("/updateEmployee")
	public String update(@ModelAttribute Employee emp, HttpSession session) {
		service.createEmployee(emp);
		session.setAttribute("message", "Employee Data updated successfully");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {
		service.deleteEmpById(id);
		session.setAttribute("message", "Employee Deleted");
		return "redirect:/";
	}
}
