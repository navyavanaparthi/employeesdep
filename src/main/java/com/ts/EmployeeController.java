package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDAO;
import com.dto.Employee;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeDAO empDAO;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empDAO.getAllEmployees();
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empId){
		return empDAO.getEmployeeById(empId);
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public Employee getEmployeeByName(@PathVariable("name") String empName) {
		return empDAO.getEmployeeByName(empName);
	}
	
	@PostMapping("/registerEmployee")
	public Employee registerEmployee(@RequestBody Employee employee) {
		return empDAO.registerEmployee(employee);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empDAO.registerEmployee(employee);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) {
		empDAO.deleteEmployee(empId);
		return "Employee Record Deleted!!!";
	}
	
	@GetMapping("/login/{emailId}/{password}")
	public Employee login(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
	    return empDAO.login(emailId, password);
	}
	
	
}














