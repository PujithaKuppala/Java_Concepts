package OOPSProblems;

import java.util.Scanner;

// Abstract class
abstract class Wizard {
    String name;
    int powerLevel;

    Wizard(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }

    abstract int castSpell(String spellName);
}

// DarkWizard subclass
class DarkWizardType extends Wizard {

    DarkWizardType(String name, int powerLevel) {
        super(name, powerLevel);
    }

    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Crucio"))
            return powerLevel * 3;
        else if (spellName.equalsIgnoreCase("AvadaKedavra"))
            return powerLevel * 5;
        else
            return powerLevel;
    }
}

// HealingWizard subclass
class HealingWizard extends Wizard {

    HealingWizard(String name, int powerLevel) {
        super(name, powerLevel);
    }

    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Heal"))
            return powerLevel * 2;
        else if (spellName.equalsIgnoreCase("Revive"))
            return powerLevel * 4;
        else
            return 0;
    }
}

// ElementalWizard subclass
class ElementalWizard extends Wizard {

    ElementalWizard(String name, int powerLevel) {
        super(name, powerLevel);
    }

    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Fireball"))
            return powerLevel * 2;
        else if (spellName.equalsIgnoreCase("Lightning"))
            return powerLevel * 3;
        else
            return powerLevel;
    }
}

// MAIN class
public class DarkWizard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Wizard Type: ");
        String type = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Power Level: ");
        int power = sc.nextInt();
        sc.nextLine();

        System.out.print("Spell: ");
        String spell = sc.nextLine();

        Wizard wizard;

        if (type.equalsIgnoreCase("DarkWizard"))
            wizard = new DarkWizardType(name, power);
        else if (type.equalsIgnoreCase("HealingWizard"))
            wizard = new HealingWizard(name, power);
        else
            wizard = new ElementalWizard(name, power);

        int damage = wizard.castSpell(spell);

        System.out.println("\nWizard: " + name);
        System.out.println("Spell Casted: " + spell);
        System.out.println("Damage Dealt: " + damage);
    }
}