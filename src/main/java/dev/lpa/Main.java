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

        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);
//        With Pig Latin Names
//        Marty artyMay Piggy
//        Meg egMay Piggy
//        Joe oeJay Piggy
//        Tom omTay Piggy
//        Bud udBay Piggy
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {

        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }
    }
}