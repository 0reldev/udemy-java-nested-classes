package dev.lpa;

import dev.lpa.domain.Employee;
import dev.lpa.domain.EmployeeComparator;
import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2016, "Walmart"),
                new StoreEmployee(10105, "Bud", 2020, "Target")));

        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator<StoreEmployee>();
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();

        // Using local class
        class NameSort<T> implements Comparator<StoreEmployee> {

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var c3 = new NameSort<StoreEmployee>();

        // Using anonymous class
        var c4 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0);
//        Sorting with Comparator: dev.lpa.domain.EmployeeComparator@2d98a335
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, c1);
//        Sorting with Comparator: dev.lpa.domain.Employee$EmployeeComparator@66a29884
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, c2);
//        Sorting with Comparator: dev.lpa.domain.StoreEmployee$StoreComparator@4769b07b
//        Macys   10105 Tom      2020
//        Target  10015 Meg      2019
//        Target  10105 Bud      2020
//        Walmart 10215 Marty    2016
//        Walmart 10515 Joe      2021

        sortIt(storeEmployees, c3);
//        Sorting with Comparator: dev.lpa.RunMethods$1NameSort@17a7cec2
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, c4);
//        Sorting with Comparator: dev.lpa.RunMethods$1@6f539caf
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
//        Sorting with Comparator: dev.lpa.RunMethods$2@50040f0c
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
//        Sorting with Comparator: dev.lpa.RunMethods$$Lambda$28/0x0000000801004cd8@4783da3f
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020

        sortIt(storeEmployees, Comparator.comparing(Employee::getName));
//        Sorting with Comparator: java.util.Comparator$$Lambda$30/0x000000080104e630@7e6cbb7a
//        Target  10105 Bud      2020
//        Walmart 10515 Joe      2021
//        Walmart 10215 Marty    2016
//        Target  10015 Meg      2019
//        Macys   10105 Tom      2020
    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {

        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }
    }


}