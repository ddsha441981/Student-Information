package com.codewithcup.studentinfo.student;

import com.codewithcup.studentinfo.employee.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired StudentService studentService;
    @GetMapping("/")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.allStudent();
        if(!students.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/single/{stdId}")
    public Student getOneUser(@PathVariable UUID stdId){
        Student student = studentService.retriveSpecficUser(stdId);
        if(student == null){
            throw new UserNotFoundException(" id " + stdId);
        }
        return student;

    }

    @PostMapping("/create")
    public ResponseEntity<Object> createStudents(@RequestBody Student student){
        Student student1 = studentService.saveStudent(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/stdId").buildAndExpand(student1.getStdId())
                .toUri();

       return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{name}")
    public String getStudentName(@PathVariable String name){
        System.out.println(name);
        return String.format(" Student Name is : %s ", name);
    }


}
