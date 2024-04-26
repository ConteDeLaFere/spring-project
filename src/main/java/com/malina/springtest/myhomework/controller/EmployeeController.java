package com.malina.springtest.myhomework.controller;

import com.malina.springtest.myhomework.model.Employee;
import com.malina.springtest.myhomework.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam int department, @RequestParam int salary) {
        return service.add(name, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam int department, @RequestParam int salary) {
        return service.remove(name, department, salary);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String name, @RequestParam int department, @RequestParam int salary) {
        return service.find(name, department, salary);
    }


    @GetMapping("/departments/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return service.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return service.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping("/departments/all-in-department")
    public Collection<Employee> getAllEmployeesInDepartment(@RequestParam Integer departmentId) {
        return service.getAllEmployeesInDepartment(departmentId);
    }

    @GetMapping("/departments/all-by-departments")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return service.getAllEmployees();
    }
}
