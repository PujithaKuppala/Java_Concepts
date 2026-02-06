package CollectionsProblems;
import java.util.*;

public class MapProblem {

    public static void main(String[] args) {

        Map<String, Integer> currentStock = new HashMap<>();
        currentStock.put("MacBook", 5);
        currentStock.put("iPhone", 10);
        currentStock.put("AirPods", 25);

        Map<String, Integer> incomingStock = new HashMap<>();
        incomingStock.put("iPhone", 5);
        incomingStock.put("AirPods", 5);
        incomingStock.put("VisionPro", 2);

        // Update stock
        for (String product : incomingStock.keySet()) {
            int incomingQty = incomingStock.get(product);

            currentStock.put(product,
                    currentStock.getOrDefault(product, 0) + incomingQty);
        }

        // Sort by product name
        TreeMap<String, Integer> sortedStock = new TreeMap<>(currentStock);

        int totalUnits = 0;

        System.out.println("Updated Stock:");
        for (Map.Entry<String, Integer> entry : sortedStock.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            totalUnits += entry.getValue();
        }

        System.out.println("\nTotal Units in Store: " + totalUnits);
    }
}