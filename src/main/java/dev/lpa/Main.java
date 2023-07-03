package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.StoreEmployee;

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

        System.out.println("Store members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2016, "Walmart"),
                new StoreEmployee(10105, "Bud", 2020, "Target")));
        var comparator = new Employee.EmployeeComparator<>();
        storeEmployees.sort(comparator);
        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }
//        Store members
//        Target 10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020


        var genericEmployee = new StoreEmployee();
        var comparator2 = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator2);
        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }
//        Macys   10105 Tom      2020
//        Target  10015 Meg      2019
//        Target  10105 Bud      2020
//        Walmart 10215 Marty    2016
//        Walmart 10515 Joe      2021

        var comparator3 = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator3);
        for (StoreEmployee e : storeEmployees) {
            System.out.println(e);
        }
//        Macys   10105 Tom      2020
//        Target  10015 Meg      2019
//        Target  10105 Bud      2020
//        Walmart 10215 Marty    2016
//        Walmart 10515 Joe      2021
    }
}
