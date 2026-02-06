package StreamAPI;
import java.util.*;

public class FindFirstVsFindAny {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                11, 7, 3, 8, 20, 4, 15, 2, 18
        );

        // Find first even number (sequential stream)
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();

        // Find any even number (parallel stream)
        Optional<Integer> anyEven = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .findAny();

        System.out.println("First even number (findFirst): " + firstEven.orElse(null));
        System.out.println("Any even number (findAny): " + anyEven.orElse(null));
    }
}

