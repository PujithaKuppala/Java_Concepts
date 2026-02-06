package StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {

        List<List<String>> data = Arrays.asList(
                Arrays.asList("apple", "banana", "orange"),
                Arrays.asList("banana", "grape", "apple"),
                Arrays.asList("mango", "orange")
        );

        List<String> result = data.stream()
                .flatMap(List::stream)          // Flatten lists
                .distinct()                     // Remove duplicates
                .sorted(Comparator.reverseOrder()) // Reverse alphabetical order
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

