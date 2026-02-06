package ExceptionHandling;

public class FifaStats {

    // Custom Runtime Exception
    static class InvalidScoreException extends RuntimeException {
        InvalidScoreException(String message) {
            super(message);
        }
    }

    // Method to calculate goal difference
    public static int calculateGoalDifference(int scored, int conceded) {

        System.out.println("Calculating goal difference...");

        if (scored < 0 || conceded < 0) {
            throw new InvalidScoreException("Invalid score: negative values not allowed");
        }

        return scored - conceded;
    }

    public static void main(String[] args) {

        try {
            int diff = calculateGoalDifference(3, -1);
            System.out.println("Goal Difference: " + diff);

        } catch (InvalidScoreException e) {
            System.out.println("Invalid score case: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Generic error occurred");

        } finally {
            System.out.println("Match stats processed");
        }
    }
}

