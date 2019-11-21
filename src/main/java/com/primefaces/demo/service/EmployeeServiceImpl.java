package com.primefaces.demo.service;

import com.primefaces.demo.dao.EmployeeDAO;
import com.primefaces.demo.domain.Employee;
import com.primefaces.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Integer deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return 1;
    }
}
