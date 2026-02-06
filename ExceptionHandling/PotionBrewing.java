package ExceptionHandling;

public class PotionBrewing {

    // Custom Exception
    static class PotionExplosionException extends Exception {
        PotionExplosionException(String message) {
            super(message);
        }
    }

    // Brew potion method
    public static void brewPotion(int dragonBloodDrops)
            throws PotionExplosionException {

        if (dragonBloodDrops > 5) {
            throw new PotionExplosionException("Potion exploded!");
        }

        System.out.println("Potion brewed successfully.");
    }

    public static void main(String[] args) {
        try {
            brewPotion(6); // Expect failure
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}