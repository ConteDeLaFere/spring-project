package com.malina.springtest.myhomework.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;


@Getter
@EqualsAndHashCode
@ToString
public class Employee {

    private final int id;

    private final String name;

    @Setter
    private int department;

    @Setter
    private int salary;

    private static int idCounter = 1;

    public Employee(String name, int department, int salary) {
        this.id = idCounter++;
        this.name = StringUtils.capitalize(name);
        this.department = department;
        this.salary = salary;
    }



}
