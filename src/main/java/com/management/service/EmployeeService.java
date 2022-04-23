package com.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.entity.Employee;
import com.management.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
	public void createEmployee(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> emp = repo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}
	
	public void deleteEmpById(int id) {
		repo.deleteById(id);
	}
}
 