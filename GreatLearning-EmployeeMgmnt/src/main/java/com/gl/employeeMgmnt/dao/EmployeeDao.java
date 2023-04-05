package com.gl.employeeMgmnt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employeeMgmnt.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
