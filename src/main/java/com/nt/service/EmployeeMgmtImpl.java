package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepo;
@Service("empservice")
public class EmployeeMgmtImpl implements IEmployeeServiceMgmt {
	@Autowired
private EmployeeRepo repo;
	@Override
	//get All Employees
	public List<Employee> fetchAllEmployee() {
		
		return repo.findAll();
	}
	@Override
	//Employee registration
	public String EmployeeRegistration(Employee emp) {
	                                int empId=repo.save(emp).getEmpid();
		return "Employee Registered with id Value:"+empId;
	}
	@Override
	//get Employee by number
	public Employee searchEmployeeByNo(int empno) {
		         return repo.findById(empno).orElseThrow(()->new IllegalArgumentException("empployee number no found"));
	
	}
	@Override
	public String UpdateEmployee(Employee emp) {
	                                   int empId=repo.save(emp).getEmpid();
		return "Employee Updated with id value::"+empId;
	}
	@Override
	public String deleteEmployeeById(int empno) {
		                                       Optional<Employee> opt=repo.findById(empno);
		                                       if(opt.isPresent()) {
		                                    	  Employee emp= opt.get();
		                                    	 repo.deleteById(empno);
		                                    	 return "Employee deleted by id value::"+empno;
		                                       }else {
		                                    	   return "Employee id not found to deleted";
		                                       }
		
	}

}
