package com.sharda.guide.controller;

import java.util.List;

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
	
	/*@GetMapping
	@ResponseStatus(HttpStatus.OK)
    public Page<Employee>  getEmployeeList(@RequestParam(name = "firstName", required=false) String firstName, 
    								 @RequestParam(name = "lastName", required=false ) String lastName,
    								 @RequestParam(name = "emailId", required=false ) String emailId,
    								 @RequestParam(name = "pageNo", required=false) Integer pageNo,
    								 @RequestParam(name = "pageSize", required=false) Integer pageSize) throws Exception {
        return employeeService.getEmployeeList(firstName,lastName,emailId,pageNo,pageSize);
    }*/
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
    public List<Employee>  getEmployeeList(@RequestParam(name = "firstName", required=false) String firstName, 
    								 @RequestParam(name = "lastName", required=false ) String lastName,
    								 @RequestParam(name = "emailId", required=false ) String emailId) throws Exception {
        return employeeService.getEmployeeList(firstName, lastName, emailId);
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
    public Employee createEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.createEmployee(employee);
    }
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public Employee  updateEmployee(@PathVariable(value = "id") Long id,@RequestBody Employee employee) throws Exception {
		log.info("FirstName : "+employee.getFirstName());
		log.info("LastName : "+employee.getLastName());
		log.info("EmailId : "+employee.getEmailId());
        return employeeService.updateEmployee(id,employee);
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable(value = "id") Long id) throws Exception {
         employeeService.deleteEmployee(id);
    }
	
	
	

}
