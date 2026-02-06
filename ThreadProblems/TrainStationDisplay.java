package ThreadProblems;
// File: TrainStationDisplay.java

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// Step 1: Create DisplayBoard class
class DisplayBoard {

    public synchronized void update(String trainName) {
        System.out.println(trainName + " updating display board.");

        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("Display: Train " + trainName + " arrived at " + time);

        System.out.println(trainName + " done updating.");
    }
}

// Step 2: Create Train class extending Thread
class Train extends Thread {
    private String trainName;
    private DisplayBoard board;
    private Random random = new Random();

    Train(String trainName, DisplayBoard board) {
        this.trainName = trainName;
        this.board = board;
    }

    @Override
    public void run() {
        try {
            System.out.println(trainName + " is arriving...");
            Thread.sleep(random.nextInt(1000) + 500); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        board.update(trainName);
    }
}

// Step 3: Main class
public class TrainStationDisplay {
    public static void main(String[] args) {

        DisplayBoard board = new DisplayBoard();

        Train t1 = new Train("Rajdhani Express", board);
        Train t2 = new Train("Shatabdi Express", board);

        t1.start();

        try {
            Thread.sleep(2000); // ensure order matches sample output
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}