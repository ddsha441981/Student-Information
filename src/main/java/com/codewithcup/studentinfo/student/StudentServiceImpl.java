package com.codewithcup.studentinfo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private static List<Student> students;
    static int count = 3;

    static {
        students = List.of(
                new Student(UUID.randomUUID(), "Alisa", "alisa12345@gmail.com", Student.Gender.FEMALE),
                new Student(UUID.randomUUID(), "Deendayal", "kkumawat1111@gmail.com", Student.Gender.MALE),
                new Student(UUID.randomUUID(), "James", "james5@gmail.com", Student.Gender.MALE),
                new Student(UUID.randomUUID(), "Amigo", "amigoTech@gmail.com", Student.Gender.MALE)
        );
    }

    @Override
    public List<Student> allStudent() {
        return students;
    }
    @Override
    public Student retriveSpecficUser(UUID stdId) {
        System.out.println("------------------" + stdId);
        for (Student std:students) {
            System.out.println(std.getStdId() + "=>"  + stdId);
                std.setStdId(stdId);
                return std;
            }
        return null;
        }

    @Override
    public Student saveStudent(Student student) {
//        if(student.getStdId() == null){
//            student.setStdId(UUID.randomUUID());
//        }
        students.add(student);
        return student;
    }
}

