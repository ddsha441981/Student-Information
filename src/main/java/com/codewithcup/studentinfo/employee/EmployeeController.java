package com.codewithcup.studentinfo.employee;

import com.codewithcup.studentinfo.employee.exception.EmployeeListException;
import com.codewithcup.studentinfo.employee.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> getEmployeesList() {
        List<Employee> employeeList = employeeService.getEmployeeList();
        if (employeeList.isEmpty() && employeeList == null) {
            throw new EmployeeListException("employee List %" + employeeList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("/all/{empId}")
    public Employee getEmployeesOne(@PathVariable int empId) {
        Employee oneEmployee = employeeService.getOneEmployee(empId);
        if(oneEmployee == null)
             throw new UserNotFoundException("id { } " + empId);

            return oneEmployee;
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
        Employee employee = employeeService.deleteEmployee(empId);
        if(employee == null){
            throw new UserNotFoundException("id {}" + empId);
        }

    }
}
