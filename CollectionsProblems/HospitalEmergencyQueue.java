package CollectionsProblems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalEmergencyQueue {

    public static void main(String[] args) {

        // Step 1: Normal arrival queue (FIFO)
        Queue<Patient> arrivalQueue = new LinkedList<>();
        arrivalQueue.add(new Patient("Arjun", 5));
        arrivalQueue.add(new Patient("Mia", 9));
        arrivalQueue.add(new Patient("Leo", 7));
        arrivalQueue.add(new Patient("Sara", 10));

        // Step 2: Emergency queue (higher severity first)
        PriorityQueue<Patient> emergencyQueue =
                new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        // Step 3: Normal treatment queue
        Queue<Patient> normalQueue = new LinkedList<>();

        // Step 4: Separate emergency and normal patients
        while (!arrivalQueue.isEmpty()) {
            Patient patient = arrivalQueue.poll();

            if (patient.severity > 8) {
                emergencyQueue.add(patient);
            } else {
                normalQueue.add(patient);
            }
        }

        // Step 5: Treat emergency patients first
        while (!emergencyQueue.isEmpty()) {
            System.out.println("Emergency case -> " + emergencyQueue.poll().name);
        }

        // Step 6: Treat normal patients
        while (!normalQueue.isEmpty()) {
            System.out.println("Treating -> " + normalQueue.poll().name);
        }
    }
}