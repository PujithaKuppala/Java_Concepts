package ExceptionHandling;

public class NasaLaunchControl {

    // Custom Exception
    static class MissionAbortException extends Exception {
        MissionAbortException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void validateLaunch(int fuel, String weather)
            throws MissionAbortException {

        try {
            // Fuel check
            if (fuel < 80) {
                throw new Exception("Fuel level too low");
            }

            try {
                // Weather check
                if (!weather.equals("CLEAR")) {
                    throw new Exception("Weather not clear");
                }
            } catch (Exception weatherEx) {
                throw new MissionAbortException(
                        "Mission aborted due to weather issue", weatherEx);
            }

        } catch (Exception fuelEx) {
            throw new MissionAbortException(
                    "Mission aborted due to fuel issue", fuelEx);
        }
    }

    public static void main(String[] args) {

        try {
            validateLaunch(60, "STORM");
            System.out.println("Mission launched successfully");

        } catch (MissionAbortException e) {
            System.out.println(e.getMessage());
            System.out.println("Retrying mission...");
        }
    }
}
