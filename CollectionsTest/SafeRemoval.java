package CollectionsTest;

import java.util.ArrayList;
import java.util.List;

public class SafeRemoval {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Safe removal without iterator warning
        list.removeIf(n -> n % 20 == 0);

        System.out.println(list);
    }
}