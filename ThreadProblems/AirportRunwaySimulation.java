package ThreadProblems;// File: AirportRunwaySimulation.java

// Step 1: Define a Runway class
class Runway {

    // synchronized method → only one plane at a time
    synchronized void useRunway(String planeId) {
        System.out.println(planeId + " requesting permission to take off.");
        System.out.println(planeId + " taking off...");
        System.out.println(planeId + " has successfully taken off.");
    }
}

// Step 2: Define a Plane class extending Thread
class Plane extends Thread {
    private final String planeId;
    private final Runway runway;

    Plane(String planeId, Runway runway) {
        this.planeId = planeId;
        this.runway = runway;
    }

    @Override
    public void run() {
        // Plane requests to use runway
        runway.useRunway(planeId);
    }
}

// Step 3: Main class
public class AirportRunwaySimulation {
    public static void main(String[] args) {

        // Create one runway
        Runway runway = new Runway();

        // Create plane threads
        Plane p1 = new Plane("AI101", runway);
        Plane p2 = new Plane("BA202", runway);
        Plane p3 = new Plane("EK303", runway);

        // Start threads
        p1.start();
        p2.start();
        p3.start();
    }
}
