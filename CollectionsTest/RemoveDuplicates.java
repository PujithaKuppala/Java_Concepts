package CollectionsTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> inputList) {
        // LinkedHashSet preserves insertion order and removes duplicates
        Set<Integer> set = new LinkedHashSet<>(inputList);

        // Convert back to List
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);

        List<Integer> result = removeDuplicates(numbers);

        System.out.println("Original List  : " + numbers);
        System.out.println("Result List    : " + result);
    }
}
