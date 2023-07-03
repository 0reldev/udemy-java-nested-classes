package dev.lpa;

import dev.lpa.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee( 10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018)));

        employees.sort(new Employee.EmployeeComparator<>());
        for (Employee e : employees) {
            System.out.println(e);
        }
//        10005 Carole   2021
//        10022 Jane     2013
//        10050 Jim      2018
//        13151 Laura    2020
//        10001 Ralph    2015

        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        for (Employee e : employees) {
            System.out.println(e);
        }
//        10022 Jane     2013
//        10001 Ralph    2015
//        10050 Jim      2018
//        13151 Laura    2020
//        10005 Carole   2021

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for (Employee e : employees) {
            System.out.println(e);
        }
//        10005 Carole   2021
//        13151 Laura    2020
//        10050 Jim      2018
//        10001 Ralph    2015
//        10022 Jane     2013
    }
}
