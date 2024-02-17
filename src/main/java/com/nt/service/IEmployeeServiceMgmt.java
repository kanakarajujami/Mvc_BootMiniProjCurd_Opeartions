package com.nt.service;

import java.util.List;



import com.nt.entity.Employee;

public interface IEmployeeServiceMgmt {
public List<Employee> fetchAllEmployee();
public String EmployeeRegistration(Employee emp) ;
public Employee searchEmployeeByNo(int empno);
public String UpdateEmployee(Employee emp);
public String deleteEmployeeById(int empno);
}
