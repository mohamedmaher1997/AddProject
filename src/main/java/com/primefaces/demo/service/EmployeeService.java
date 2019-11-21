package com.primefaces.demo.service;

import com.primefaces.demo.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee getEmployeeById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        if(employee!=null)
        {
            if(employee.getEmployeeId()==null)
            {
                entityManager.persist(employee);
            }else{
                entityManager.merge(employee);
            }
            return employee;
        }else {
            throw new RuntimeException("Employee can not be null");
        }
    }

    public Integer deleteEmployeeById(Integer employeeId) {
        if(employeeId!=null)
        {
            Employee employee = entityManager.find(Employee.class,employeeId);
            entityManager.remove(employee);
            return 1;
        }
        return -1;
    }

    public List<Employee> getAllEmployees() {
        Query query = entityManager.createNamedQuery("query_find_all_employees",Employee.class);
        return new ArrayList<>(query.getResultList());
    }

}
