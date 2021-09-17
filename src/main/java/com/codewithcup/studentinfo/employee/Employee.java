package com.codewithcup.studentinfo.employee;

import com.codewithcup.studentinfo.employee.enums.Gender;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Data
public class Employee {
    private int empId;
    @NotNull
    @Size(min = 2,message="name must be between min 2 to 15 ")
    private String empName;
    @Size(min = 1,message = "email cann't be blank")
    private String empEmail;
    @NotNull
    @Past
    private Date dob;
    @NotNull
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
