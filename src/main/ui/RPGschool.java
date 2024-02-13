package ui;

import model.Character;

import java.util.Scanner;

public class RPGschool {
    private final Scanner scanner;

    public RPGschool(Character c) {
        scanner = new Scanner(System.in);
        while (true) {
            displayCharacterStats(c);
            displaySchoolMenu();
            selectSchoolMenu(c);
        }
    }

    public void displayCharacterStats(Character c) {
        System.out.println("\nName: " + c.getName());
        System.out.println("Sex: " + (c.getIsMale() ? "Male" : "Female"));
        System.out.println("\tHealth: " + c.getHealth());
        System.out.println("\tAttack Power: " + c.getAttackPower());
        System.out.println("\tDefense Power: " + c.getDefensePower());
    }

    public void displaySchoolMenu() {
        System.out.println("\nWelcome to the academy!");
        System.out.println("\nActions: ");
        System.out.println("1. Train");
        System.out.println("2. Gain special ability");
    }

    public void selectSchoolMenu(Character c) {
        System.out.println("\n Enter a number: ");
        String response = scanner.next();
        if (response.equals("1")) {
            train(c);
        } else if (response.equals("2")) {
            gainSpecialAbility(c);
        } else {
            System.out.println("Invalid input!");
            selectSchoolMenu(c);
        }
    }

    public void train(Character c) {
        System.out.println("How long would you like " + c.getName() + " train for?");
        int trainingHours = scanner.nextInt();
        int experienceGained = trainingHours * 10; // Gain 10 experience points per training hour

        c.setAttackPower(c.getAttackPower() + trainingHours);
        c.setDefensePower(c.getDefensePower() + trainingHours);

        System.out.println("\nTraining completed! " + c.getName() + " gained " + experienceGained
                + " experience points.");
    }

    public void gainSpecialAbility(Character c) {
        System.out.println("What ability do you want " + c.getName() + " gain?");
        String ability = scanner.next();
        switch (ability.toLowerCase()) {
            case "accelerated healing":
                System.out.println("\n" + c.getName() + " has gained the special ability: Accelerated Healing!");
                break;
            case "resistance":
                System.out.println("\n" + c.getName() + " has gained the special ability: Resistance!");
                break;
            case "swiftness":
                System.out.println("\n" + c.getName() + " has gained the special ability: Swiftness!");
                break;
            default:
                System.out.println("\nInvalid special ability.");
        }
    }
}
