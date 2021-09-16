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
                new Employee(111,"Alisa","alisa@gmail.com",new Date(),Employee.Gender.FEMALE),
                new Employee(112,"Jhon","Jhon@gmail.com",new Date(),Employee.Gender.MALE),
                new Employee(113,"Samntha","Samantha@gmail.com",new Date(),Employee.Gender.FEMALE),
                new Employee(114,"James","James@gmail.com",new Date(),Employee.Gender.MALE),
                new Employee(115,"Jonny","Jonney@gmail.com",new Date(),Employee.Gender.MALE)
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
//        System.out.println("========================" + employee.toString());

        employee.setEmpId(++count);
        System.out.println("========================" + employee.toString());
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
