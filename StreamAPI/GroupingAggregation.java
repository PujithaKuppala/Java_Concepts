package StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class GroupingAggregation {

    // Employee class
        record Employee(String department, double salary) {
    }

    // Main method
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("IT", 80000),
                new Employee("IT", 90000),
                new Employee("HR", 50000),
                new Employee("HR", 60000),
                new Employee("Finance", 70000)
        );

        // Group by department and calculate average salary
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));

        System.out.println(avgSalaryByDept);
    }
}

