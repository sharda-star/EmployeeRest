package com.sharda.guide.service;

import org.springframework.data.domain.Page;

import com.sharda.guide.model.Employee;

public interface EmployeeService {

	Employee getEmployee(Long id) throws Exception;

	Employee createEmployee(Employee employee)throws Exception;

	void deleteEmployee(Long id);

	Page<Employee> getEmployeeList(String firstName, String lastName, String emailId,Integer pageNo, Integer pageSize);

	Employee updateEmployee(Long id, Employee employee) throws Exception;

}
