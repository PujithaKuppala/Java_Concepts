package CollectionsTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount {

    public static void main(String[] args) {

        // Input list
        List<String> words = new ArrayList<>();
        words.add("Java");
        words.add("Collections");
        words.add("Java");
        words.add("Map");
        words.add("Collections");
        words.add("Java");

        // Method call
        Map<String, Integer> frequencyMap = getFrequencyMap(words);

        // Output
        System.out.println(frequencyMap);
    }

    // Extracted method (this removes the warning)
    private static Map<String, Integer> getFrequencyMap(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}