package CollectionsTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentElement {

    public static int findMostFrequentElement(List<Integer> numbers) {

        // Step 1: Frequency count
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer num : numbers) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        // Step 2: Find the highest frequency and smallest element
        int maxFrequency = 0;
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                result = element;
            } else if (frequency == maxFrequency && element < result) {
                result = element;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(4);

        int mostFrequent = findMostFrequentElement(list);

        System.out.println("Most Frequent Element: " + mostFrequent);
    }
}

