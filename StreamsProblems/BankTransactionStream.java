package StreamsProblems;
import java.util.*;
import java.util.stream.*;

public class BankTransactionStream {
    public static void main(String[] args) {

        List<String> transactions = List.of(
                "TXN1001:SAVINGS:12000",
                "TXN1002:CURRENT:15000",
                "TXN1003:SAVINGS:20000",
                "TXN1004:SAVINGS:12000",
                "TXN1005:SAVINGS:8000",
                "TXN1006:CURRENT:30000"
        );

        // Process transactions
        List<Double> processedAmounts = transactions.stream()
                // split transaction string
                .map(txn -> txn.split(":"))
                // consider only SAVINGS accounts
                .filter(parts -> parts[1].equals("SAVINGS"))
                // extract amount
                .map(parts -> Double.parseDouble(parts[2]))
                // amount >= 10000
                .filter(amount -> amount >= 10000)
                // add 18% GST
                .map(amount -> amount + (amount * 0.18))
                // remove duplicates
                .distinct()
                // sort in descending order
                .sorted(Comparator.reverseOrder())
                .toList();

        // count amounts > 20000
        long count = processedAmounts.stream()
                .filter(amount -> amount > 20000)
                .count();

        System.out.println("Processed Amounts: " + processedAmounts);
        System.out.println("Count of amounts > 20000: " + count);
    }
}

