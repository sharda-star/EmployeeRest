package com.sharda.guide.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
    public Employee  getEmployeeList(@RequestParam(name = "firstName") String firstName, 
    								 @RequestParam(name = "lastName") String lastName) throws Exception {
        return employeeService.getEmployeeList(firstName,lastName);
    }
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
    public Employee createEmployee(@RequestBody Employee employee) throws Exception {
		log.info("FirstName : "+employee.getFirstName());
		log.info("LastName : "+employee.getLastName());
		log.info("EmailId : "+employee.getEmailId());
        return employeeService.createEmployee(employee);
    }
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
    public Employee  updateEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.updateEmployee(employee);
    }
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable(value = "id") Long id) throws Exception {
         employeeService.deleteEmployee(id);
    }
	
	
	

}
