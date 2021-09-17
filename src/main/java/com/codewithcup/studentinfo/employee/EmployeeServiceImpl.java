package com.codewithcup.studentinfo.employee;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

     int count = 5;
    private static List<Employee> employeeList;
    //static data
    static {

        employeeList = List.of(
                new Employee(1,"Alisa","alisa@gmail.com",new Date(),Employee.Gender.FEMALE),
                new Employee(2,"Jhon","Jhon@gmail.com",new Date(),Employee.Gender.MALE),
                new Employee(3,"Samntha","Samantha@gmail.com",new Date(),Employee.Gender.FEMALE),
                new Employee(4,"James","James@gmail.com",new Date(),Employee.Gender.MALE),
                new Employee(5,"Jonny","Jonney@gmail.com",new Date(),Employee.Gender.MALE)
        );
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Employee getOneEmployee(int empId) {
        for (Employee element : employeeList) {
            if (element.getEmpId() == empId) {
                return element;
            }
        }
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
//        if(employee.getEmpId()==null){
//            employee.setEmpId(++count);
//        }
        employee.setEmpId(++count);
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(int empId) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()){
            Employee e = iterator.next();
            if(e.getEmpId()==empId){
                iterator.remove();
                return e;
            }
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
}
