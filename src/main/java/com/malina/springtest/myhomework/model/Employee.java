package com.malina.springtest.myhomework.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@EqualsAndHashCode
@ToString
public class Employee {

    @Getter
    private final int id;

    @Getter
    private final String name;

    @Getter
    @Setter
    private int department;

    @Getter
    @Setter
    private int salary;

    private static int idCounter = 1;

    public Employee(String name, int department, int salary) {
        this.id = idCounter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }



}
