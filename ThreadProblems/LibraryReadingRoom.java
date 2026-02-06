package ThreadProblems;// File: LibraryReadingRoom.java

// Step 1: Create ReadingRoom class
class ReadingRoom {
    private int totalSeats;
    private int occupiedSeats = 0;

    ReadingRoom(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public synchronized void enter(String studentName) {
        try {
            if (occupiedSeats == totalSeats) {
                System.out.println(studentName + " waiting for a seat.");
                wait();
            }
            occupiedSeats++;
            System.out.println(studentName +
                    " entered the reading room. (Occupied: " + occupiedSeats + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void leave(String studentName) {
        occupiedSeats--;
        System.out.println(studentName +
                " left the reading room. (Occupied: " + occupiedSeats + ")");
        notifyAll();
    }
}

// Step 2: Create Student thread class
class Student extends Thread {
    private String studentName;
    private ReadingRoom room;
    private int stayTime;

    Student(String studentName, ReadingRoom room, int stayTime) {
        this.studentName = studentName;
        this.room = room;
        this.stayTime = stayTime;
    }

    @Override
    public void run() {
        room.enter(studentName);
        try {
            Thread.sleep(stayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        room.leave(studentName);
    }
}

// Step 3: Main class
public class LibraryReadingRoom {
    public static void main(String[] args) {

        ReadingRoom room = new ReadingRoom(2);

        Student s1 = new Student("S1", room, 2000);
        Student s2 = new Student("S2", room, 3000);
        Student s3 = new Student("S3", room, 1000);

        s1.start();
        s2.start();

        try {
            Thread.sleep(100); // ensure S1 & S2 enter first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s3.start();
    }
}
