package com.malina.springtest.myhomework.service;

import com.malina.springtest.myhomework.exception.EmployeeAlreadyAddedException;
import com.malina.springtest.myhomework.exception.EmployeeNotFoundException;
import com.malina.springtest.myhomework.exception.StringFormatException;
import com.malina.springtest.myhomework.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String name, int department, int salary) {
        if (!StringUtils.isAlpha(name)) {
            throw new StringFormatException("Имя должно содержать только буквы");
        }
        name = StringUtils.capitalize(name);
        Employee employee = new Employee(name, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String name, int department, int salary) {
        if (!StringUtils.isAlpha(name)) {
            throw new StringFormatException("Имя должно содержать только буквы");
        }
        name = StringUtils.capitalize(name);
        Employee employee = new Employee(name, department, salary);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee find(String name, int department, int salary) {
        if (!StringUtils.isAlpha(name)) {
            throw new StringFormatException("Имя должно содержать только буквы");
        }
        name = StringUtils.capitalize(name);
        Employee employee = new Employee(name, department, salary);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Cотрудник не найден"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Cотрудник не найден"));
    }

    @Override
    public Collection<Employee> getAllEmployeesInDepartment(Integer departmentId) {
        List<Integer> list = List.of(1, 2, 4);
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
