package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Employee;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int empId) {
		Employee emp = new Employee(0, "Employee Not Found!!!", 0.0, "", null, "", "");
		return employeeRepository.findById(empId).orElse(emp);
	}

	public Employee getEmployeeByName(String empName) {
		Employee emp = new Employee(0, "Employee Not Found!!!", 0.0, "", null, "", "");
		
		Employee employee = employeeRepository.getEmployeeByName(empName);
		
		if (employee != null) {
			return employee;
		}
		 
		return emp;
	}

	public Employee registerEmployee(Employee emp) {
		return employeeRepository.save(emp);	
	}

	public void deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
	}
	
	public Employee login(String emailId, String password) {
	    return employeeRepository.login(emailId, password);
	}
	
}











