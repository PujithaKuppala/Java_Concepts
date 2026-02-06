package OOPSProblems;

import java.util.Scanner;

// Abstract class
abstract class Missile {
    String missileId;
    int range;

    Missile(String missileId, int range) {
        this.missileId = missileId;
        this.range = range;
    }

    abstract boolean launch(int threatLevel, boolean hasClearance);
}

// NuclearMissile subclass
class NuclearMissile extends Missile {

    NuclearMissile(String missileId, int range) {
        super(missileId, range);
    }

    boolean launch(int threatLevel, boolean hasClearance) {
        return threatLevel >= 9 && hasClearance;
    }
}

// TorpedoMissile subclass
class TorpedoMissile extends Missile {

    TorpedoMissile(String missileId, int range) {
        super(missileId, range);
    }

    boolean launch(int threatLevel, boolean hasClearance) {
        return threatLevel >= 5;
    }
}

// DefenseInterceptor subclass
class DefenseInterceptor extends Missile {

    DefenseInterceptor(String missileId, int range) {
        super(missileId, range);
    }

    boolean launch(int threatLevel, boolean hasClearance) {
        return threatLevel >= 3;
    }
}

// MAIN class
public class MissileLaunch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Missile Type: ");
        String type = sc.nextLine();

        System.out.print("Missile ID: ");
        String id = sc.nextLine();

        System.out.print("Threat Level: ");
        int threat = sc.nextInt();

        System.out.print("Clearance (true/false): ");
        boolean clearance = sc.nextBoolean();

        Missile missile;

        if (type.equalsIgnoreCase("NuclearMissile"))
            missile = new NuclearMissile(id, 1000);
        else if (type.equalsIgnoreCase("TorpedoMissile"))
            missile = new TorpedoMissile(id, 500);
        else
            missile = new DefenseInterceptor(id, 300);

        boolean approved = missile.launch(threat, clearance);

        System.out.println("\nMissile ID: " + id);

        if (approved) {
            System.out.println("Launch Status: APPROVED");
            if (type.equalsIgnoreCase("DefenseInterceptor"))
                System.out.println("Interceptor launched successfully");
            else
                System.out.println("Missile launched successfully");
        } else {
            System.out.println("Launch Status: DENIED");
            if (type.equalsIgnoreCase("NuclearMissile"))
                System.out.println("Reason: Threat level insufficient for nuclear launch");
            else
                System.out.println("Reason: Launch conditions not met");
        }

        sc.close();
    }
}
