package com.primefaces.demo.controller;

import com.primefaces.demo.dao.EmployeeDAO;
import com.primefaces.demo.domain.Employee;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Scope (value = "session")
@Component (value = "employeeController")
@ELBeanName(value = "employeeController")
@Join(path = "/", to = "/home.jsf")
 
public class EmployeeController {

    private String operation = "Add Record";

    public String getOperation() {
        return operation;
    }

    @Autowired
    private EmployeeDAO employeeDAO;

    private Employee employee = new Employee();

    private List<Employee> employeeList = new ArrayList<>();//employeeImplJPA.getAllEmployees();

    public Employee getEmployee() {
        return employee;
    }

    public List<Employee> getEmployeeList() {
        employeeList = employeeDAO.getAllEmployees();
        return employeeList;
    }

    public List<Employee> getEmployees()
    {
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        return employeeList;
    }

    public String getEmployee(Employee emp)
    {
        employee = employeeDAO.getEmployeeById(emp.getEmployeeId());
        operation = "Update Record";
        return "employees?faces-redirect=true";
    }
  
        public String saveOrUpdateEmployee()
    {
        employeeDAO.saveOrUpdateEmployee(employee);
        employee = new Employee();
        employeeList = getEmployees();
        operation = "Add Record";
        return "/employees.xhtml?faces-redirect=true";
    }

    public String deleteEmployee(Employee emp)
    {
        @SuppressWarnings("unused")
		Integer result = employeeDAO.deleteEmployeeById(emp.getEmployeeId());
        employeeList = getEmployees();
        return "/employees?faces-redirect=true";
    }

    public String loadIndexPage()
    {
        System.out.println("Demo");
        return "/home?faces-redirect=true";
    }
}
