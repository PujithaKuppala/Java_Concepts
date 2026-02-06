package StreamAPI;
import java.util.*;

public class CustomCollector {

    // Custom result class
    static class WordCountResult {
        private int totalWords;
        private final Set<String> distinctWords = new HashSet<>();

        public void addSentence(String sentence) {
            String[] words = sentence.split("\\s+");
            totalWords += words.length;
            distinctWords.addAll(Arrays.asList(words));
        }

        public void merge(WordCountResult other) {
            this.totalWords += other.totalWords;
            this.distinctWords.addAll(other.distinctWords);
        }

        public int getTotalWords() {
            return totalWords;
        }

        public int getDistinctWordCount() {
            return distinctWords.size();
        }

        @Override
        public String toString() {
            return "Total Words = " + totalWords +
                    ", Distinct Words = " + getDistinctWordCount();
        }
    }

    // Main method
    public static void main(String[] args) {

        List<String> sentences = Arrays.asList(
                "java stream api",
                "java custom collector",
                "stream api java"
        );

        WordCountResult result = sentences.stream().collect(
                WordCountResult::new,      // supplier
                WordCountResult::addSentence, // accumulator
                WordCountResult::merge     // combiner
        );

        System.out.println(result);
    }
}

