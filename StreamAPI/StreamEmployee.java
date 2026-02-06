package StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class StreamEmployee {

    // Employee class
        record Employee(int id, String name, double salary) {
        // FIXED: id now used
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ravi", 80000),
                new Employee(2, "Anil", 60000),
                new Employee(3, "Suresh", 90000),
                new Employee(4, "Kiran", 75000),
                new Employee(5, "Bhanu", 85000)
        );

        List<String> result = employees.stream()
                .filter(e -> e.salary() > 75000)
                .map(Employee::name)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}