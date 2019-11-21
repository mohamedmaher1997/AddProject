package com.primefaces.demo.dao;

import com.primefaces.demo.domain.Employee;

import java.util.List;

public interface EmployeeDAO {

    public Employee getEmployeeById(Integer employeeId);
    public List<Employee> getAllEmployees();
    public Employee saveOrUpdateEmployee(Employee employee);
    public Integer deleteEmployeeById(Integer employeeId);

}
