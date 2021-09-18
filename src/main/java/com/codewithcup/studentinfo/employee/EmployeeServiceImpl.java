package com.codewithcup.studentinfo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.codewithcup.studentinfo.employee.dummydata.EmployeeDummy.employeeList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
//       return employeeList;
    }

    @Override
    public Employee getOneEmployee(int empId) {
        Optional<Employee> eById = employeeRepository.findById(empId);
        if(eById.isPresent()){
            return eById.get();
        }
//        for (Employee element : employeeList) {
//            if (element.getEmpId() == empId) {
//                return element;
//            }
        return null;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
//        if(employee.getEmpId()==null){
//            employee.setEmpId(++count);
//        }
//        employee.setEmpId(++count);
//        employeeList.add(employee);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(int empId) {
//        Iterator<Employee> iterator = employeeList.iterator();
//        while (iterator.hasNext()) {
//            Employee e = iterator.next();
//            if (e.getEmpId() == empId) {
//                iterator.remove();
//                return e;
//            }
//        }
//        return null;
        Employee employee = new Employee();
        employee.setEmpId(empId);
       employeeRepository.deleteById(empId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }
}
