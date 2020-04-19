package com.sharda.guide.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Employee getEmployeeList(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
