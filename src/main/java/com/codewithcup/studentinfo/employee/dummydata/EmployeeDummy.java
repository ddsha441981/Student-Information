package com.codewithcup.studentinfo.employee.dummydata;

import com.codewithcup.studentinfo.employee.Employee;

import java.util.Date;
import java.util.List;

public class EmployeeDummy {

    static int count = 5;
    public  static List<Employee> employeeList;

    //static data
    static {

        employeeList = List.of(
                new Employee(1, "Alisa", "alisa@gmail.com", new Date(), Employee.Gender.FEMALE, Employee.Country.UK),
                new Employee(2, "Jhon", "Jhon@gmail.com", new Date(), Employee.Gender.MALE, Employee.Country.US),
                new Employee(3, "Samntha", "Samantha@gmail.com", new Date(), Employee.Gender.FEMALE, Employee.Country.FA),
                new Employee(4, "James", "James@gmail.com", new Date(), Employee.Gender.MALE, Employee.Country.IN),
                new Employee(5, "Jonny", "Jonney@gmail.com", new Date(), Employee.Gender.MALE, Employee.Country.JA)
        );
    }
}
