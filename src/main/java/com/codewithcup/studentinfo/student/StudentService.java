package com.codewithcup.studentinfo.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    //retrive all Student
    public List<Student> allStudent();
    //retrive dtudent by Id
    public Student retriveSpecficUser(UUID stdId);

    //save student
    public Student saveStudent(Student student);
}
