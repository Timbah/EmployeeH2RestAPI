package com.ngema.employees.dao;

import com.ngema.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //That's it, no need to write any code!
}
