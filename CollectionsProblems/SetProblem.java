package CollectionsProblems;
import java.util.*;
public class SetProblem {
    public static void main(String[] args) {
        List<String> applicants = Arrays.asList(
                "John", "Aisha", "Ravi", "John", "Mina", "Ravi", "Aisha", "Tom"
        );

        Set<String> uniqueApplicants = new HashSet<>(applicants);

        int duplicatesRemoved = applicants.size() - uniqueApplicants.size();

        System.out.println("Unique Applicants: " + uniqueApplicants);
        System.out.println("Duplicates Removed: " + duplicatesRemoved);
    }
}