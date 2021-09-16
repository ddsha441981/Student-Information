package com.codewithcup.studentinfo.employee;

import com.codewithcup.studentinfo.employee.enums.Gender;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Data
public class Employee {
    private int empId;
    private String empName;
    private String empEmail;
    private Date dob;
    private Gender gender;

    public enum Gender {
        MALE,FEMALE
    }

    public Employee(int empId, String empName, String empEmail, Date dob, Gender gender) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.dob = dob;
        this.gender = gender;
    }
}
