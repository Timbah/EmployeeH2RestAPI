package com.ngema.employees.dao;

import com.ngema.employees.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //Means that this class accesses a database
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager; //Brings the ability to create a query

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //Create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //Execute query and get results list
        List<Employee> employees = theQuery.getResultList();

        //return the results ss
        return employees;
    }

    @Override
    public Employee findById(long theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }
//testst
    @Override
    public void deleteById(long theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);

    }

}
