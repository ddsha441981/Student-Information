package com.codewithcup.studentinfo.employee;

import com.codewithcup.studentinfo.employee.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-list")
    public ResponseEntity<?> retriveAllEmployees() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("/{empId}")
    public EntityModel<Employee> getEmployeesOne(@PathVariable int empId) {
        Employee oneEmployee = employeeService.getOneEmployee(empId);
        if (oneEmployee == null)
            throw new UserNotFoundException("id { } " + empId);

        //"all-users" + SERVER_PATH+ "/users"
        //retriveAllEmployees
        //HATEOAS
        /*-------------------------------------- //HATEOAS//------------------------------------------------*/
        EntityModel<Employee> entity = EntityModel.of(oneEmployee);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllEmployees());
        entity.add(linkTo.withRel("employee-list"));
        /*-------------------------------------- //HATEOAS//------------------------------------------------*/
        return entity;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEmployees(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{empId}")
                .buildAndExpand(savedEmployee.getEmpId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployees() {
        return null;
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployeesOne(@PathVariable int empId) {
         employeeService.deleteEmployee(empId);
//        if (employee == null) {
//            throw new UserNotFoundException("id {}" + empId);
//        }
    }

    //Internationalize
    @GetMapping("/hello-world-internationalized")
    public String helloWorldNameInternationalized(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
