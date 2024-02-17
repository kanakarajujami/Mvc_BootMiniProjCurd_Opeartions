package com.nt.entity;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_info")
public class Employee implements Serializable {
	@Id
	@Column
	@SequenceGenerator(name="gen1", initialValue=100,allocationSize=5,sequenceName="emp_seq")
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
private int empid;
@Column(length=25)
private String empname;
@Column(length=25)
private String empdesg="Developer";
@Column
private float empsal;


public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpdesg() {
	return empdesg;
}
public void setEmpdesg(String empdesg) {
	this.empdesg = empdesg;
}
public float getEmpsal() {
	return empsal;
}
public void setEmpsal(float empsal) {
	this.empsal = empsal;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + ", empdesg=" + empdesg + ", empsal=" + empsal + "]";
}

}
