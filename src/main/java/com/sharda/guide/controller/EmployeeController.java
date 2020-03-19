package com.sharda.guide.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sharda.guide.model.Employee;
import com.sharda.guide.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Employee  getEmployee(@PathVariable(value = "id") Long id) throws Exception {
        return employeeService.getEmployee(id);
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
    public Employee  createEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.createEmployee(employee);
    }
	

}
