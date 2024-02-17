package com.nt.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeServiceMgmt;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeServiceMgmt service;
	@GetMapping("/")
public String showHomePage() {
		//returns logical view name
	return "welcome";
}
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		                     List<Employee> listemp =service.fetchAllEmployee();
		                    /* for(Employee emp: listemp) {
		                    	 System.out.println("Employee:"+emp);
		                     }*/
		                     listemp.sort((emp1,emp2)->emp1.getEmpid()-emp2.getEmpid());
		                     map.put("emplist", listemp);
		                     return "show_report";
	}
	@GetMapping("/register")
	public String employeRegisterFormPage(@ModelAttribute("emp") Employee emp) {
		 return "employee_register";
	}
	/*@PostMapping("/addemp")
	public String saveEmployee(RedirectAttributes attr, @ModelAttribute("emp") Employee emp) {
		                                  String resultMsg= service.EmployeeRegistration(emp);
		                                   // List<Employee> emplist=service.fetchAllEmployee();
		                               
		                                  //  map.put("resultMsg", resultMsg);
		                                  attr.addFlashAttribute("resultMsg", resultMsg);
		                                  
		                                    return "redirect:report";*/
	
@PostMapping("/addemp")
public String saveEmployee(HttpSession session, @ModelAttribute("emp") Employee emp) {
	                                  String resultMsg= service.EmployeeRegistration(emp);
	                                   // List<Employee> emplist=service.fetchAllEmployee();
	                               
	                                  //  map.put("resultMsg", resultMsg);
	                               //   attr.addFlashAttribute("resultMsg", resultMsg);
	                                  session.setAttribute("resultMsg", resultMsg);
	                                  
	                                    return "redirect:report";
} 
@GetMapping("/edit")
public String editEmployeeFormPage(@RequestParam Integer empid,@ModelAttribute("emp") Employee emp) {
	                            Employee employee=service.searchEmployeeByNo(empid);
	                            //copy data
	                            BeanUtils.copyProperties(employee, emp);
	                            return "update_employee";
	                            
}
@PostMapping("/edit")
  public String editEmployee(@ModelAttribute("emp2") Employee emp,RedirectAttributes attr)  {
	                                     String resultMsg=service.UpdateEmployee(emp);
	                                     attr.addFlashAttribute("resultMsg", resultMsg);
	                                     return "redirect:report";
  }
@GetMapping("/delete")
public String deleteEmployee(RedirectAttributes attr,@RequestParam Integer empid) {
	                                  String msg=  service.deleteEmployeeById(empid);
	                                  attr.addFlashAttribute("resultMsg", msg);
	                                  return "redirect:report";
}
}
