package com.primefaces.demo.domain;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_details")
@NamedQuery(query = "select e from Employee e", name = "query_find_all_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column
    private String employeeName;
    @Column
    private String address;
    @Column
    private String phoneNo;

    @PostConstruct
    public void postConstruct() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    public Employee(){}

    public Employee(String employeeName, String address, String phoneNo) {
        this.employeeName = employeeName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
