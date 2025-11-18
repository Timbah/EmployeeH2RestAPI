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

        //return the results
        return employees;
    }

}
