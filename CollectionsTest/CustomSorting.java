package CollectionsTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary;
    }
}

public class CustomSorting {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // ✅ Correct constructor usage
        employees.add(new Employee(101, "Ravi", 50000));
        employees.add(new Employee(102, "Anu", 70000));
        employees.add(new Employee(103, "Ravi", 70000));
        employees.add(new Employee(104, "Anu", 70000));
        employees.add(new Employee(105, "Kiran", 50000));

        // ✅ Custom sorting logic
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {

                // 1. Salary descending
                if (e1.salary != e2.salary) {
                    return Double.compare(e2.salary, e1.salary);
                }

                // 2. Name ascending
                int nameCompare = e1.name.compareTo(e2.name);
                if (nameCompare != 0) {
                    return nameCompare;
                }

                // 3. ID ascending
                return Integer.compare(e1.id, e2.id);
            }
        });

        // Output
        System.out.println("Sorted Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
