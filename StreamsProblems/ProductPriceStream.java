package StreamsProblems;
import java.util.*;
import java.util.stream.*;

public class ProductPriceStream {
    public static void main(String[] args) {

        List<Integer> prices = List.of(
                500, 1200, 2500, 1200, 3000, 800, 2500
        );

        // Process prices
        List<Integer> processedPrices = prices.stream()
                // 1) filter prices > 1000
                .filter(price -> price > 1000)
                // 2) remove duplicates
                .distinct()
                // 3) sort in descending order
                .sorted(Comparator.reverseOrder())
                .toList();

        // 4) count prices > 2000
        long count = processedPrices.stream()
                .filter(price -> price > 2000)
                .count();

        System.out.println("Processed Prices: " + processedPrices);
        System.out.println("Count of prices > 2000: " + count);
    }
}
