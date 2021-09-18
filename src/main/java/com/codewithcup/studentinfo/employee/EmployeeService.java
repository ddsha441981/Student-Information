package com.codewithcup.studentinfo.employee;

import java.util.List;

public interface EmployeeService {
    //retrive all employee
    public List<Employee> getEmployeeList();
    //retrive by Id
    public Employee getOneEmployee(int empId);
    //add employee
    public Employee saveEmployee(Employee employee);
    //delete employee
    public void deleteEmployee(int empId);
    //update employee
    public Employee updateEmployee(Employee employee);
}
