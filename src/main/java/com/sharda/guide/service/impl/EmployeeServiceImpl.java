package com.sharda.guide.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sharda.guide.exception.EntityNotFoundException;
import com.sharda.guide.model.Employee;
import com.sharda.guide.repository.EmployeeRepository;
import com.sharda.guide.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployee(Long id) throws Exception {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(!optionalEmployee.isPresent()) {
			log.info("Employee not found by id :"+id);
			throw new EntityNotFoundException("Employee not found by id :"+id);
		}
		Employee employee = optionalEmployee.get();
		return employee;
	}

	@Override
	public Employee createEmployee(Employee employee) throws Exception {
		return employeeRepository.save(employee);
	}

	@Override
	public Page<Employee> getEmployeeList(String firstName, String lastName, String emailId,Integer pageNo, Integer pageSize){
		if(pageNo==null) {
			pageNo = 0;
		}
		if(pageSize==null){
			pageSize = 10;
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize); 
		
		Page<Employee> empList = null;
		empList = employeeRepository.findAll(pageable);
		return empList;
	}

	@Override
	public List<Employee> getEmployeeList(String firstName, String lastName, String emailId){
		List<Employee> empList = new ArrayList<>();
		empList = employeeRepository.findAll();
		return empList;
	}
	
	@Override
	public Employee updateEmployee(Long id, Employee newEmployee) throws Exception {
		Employee employee = getEmployee(id);
		if(newEmployee.getFirstName()!=null) {
			employee.setFirstName(newEmployee.getFirstName());
		}
		if(newEmployee.getLastName()!=null) {
			employee.setLastName(newEmployee.getLastName());
		}
		if(newEmployee.getEmailId()!=null) {
			employee.setEmailId(newEmployee.getEmailId());
		}
		return employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
