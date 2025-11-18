package com.ngema.employees.dao;

import com.ngema.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
