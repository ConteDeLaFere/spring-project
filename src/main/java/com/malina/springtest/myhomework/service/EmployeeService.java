package com.malina.springtest.myhomework.service;

import com.malina.springtest.myhomework.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee add(String name, int department, int salary);

    Employee remove(String name, int department, int salary);

    Employee find(String name, int department, int salary);

    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Collection<Employee> getAllEmployeesInDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployees();
}
