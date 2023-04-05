package com.gl.employeeMgmnt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.employeeMgmnt.dao.EmployeeDao;
import com.gl.employeeMgmnt.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao empDao;

	public EmployeeServiceImpl(EmployeeDao empDao) {
		super();
		this.empDao = empDao;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empDao.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empDao.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return empDao.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return empDao.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		empDao.deleteById(id);

	}

}
