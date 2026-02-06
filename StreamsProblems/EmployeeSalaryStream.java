package StreamsProblems;
import java.util.*;
public class EmployeeSalaryStream {
    public static void main(String[] args) {

        List<String> employees = List.of(
                "Alice:60000",
                "Bob:45000",
                "Charlie:75000",
                "David:60000",
                "Eva:90000"
        );

        List<Integer> annualSalaries = employees.stream()
                // extract salary
                .map(e -> Integer.parseInt(e.split(":")[1]))
                // salaries > 50000
                .filter(salary -> salary > 50000)
                // convert to annual salary
                .map(salary -> salary * 12)
                // remove duplicates
                .distinct()
                // sort descending
                .sorted(Comparator.reverseOrder())
                // skip highest salary
                .skip(1)
                // take next 2
                .limit(2)
                .toList();

        long count = annualSalaries.size();

        System.out.println("Annual Salaries After Processing: " + annualSalaries);
        System.out.println("Count: " + count);
    }
}


