package ui;

import model.Character;
import model.Trainer;

import java.util.Scanner;

// The CharacterUI class represents a CUI interface for an academy in a role-playing game (RPG).
// It serves as a main ui for training the character selected or gain special abilities for the character selected.
public class SchoolUI {
    private final Scanner scanner;

    // EFFECTS: Constructs a new 'SchoolUI' class including setting up 'scanner' fields.
    public SchoolUI(Character c) {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        runSchoolUI(c);
    }

    // EFFECTS: Instantiate a loop for the school menu for user to choose different actions for the character.
    private void runSchoolUI(Character c) {
        boolean keepGoing;
        do {
            displayCharacterStats(c);
            displaySchoolMenu();
            keepGoing = selectSchoolMenu(c);
        } while (keepGoing);
    }

    // EFFECTS: Displays the character statistics to the user.
    private void displayCharacterStats(Character c) {
        System.out.println("\n\tName: " + c.getName());
        System.out.println("\tSex: " + (c.getIsMale() ? "Male" : "Female"));
        System.out.println("\tExp: " + c.getExperience());
        System.out.println("\tLevel: " + c.getLevel());
        System.out.println("\tHealth: " + c.getHealth());
        System.out.println("\tAttack Power: " + c.getAttackPower());
        System.out.println("\tDefense Power: " + c.getDefensePower());
    }

    // EFFECTS: Displays the school menu options to the user.
    private void displaySchoolMenu() {
        System.out.println("\nWelcome to the academy!");
        System.out.println("\tHere you can train your character to obtain special abilities and enhance their skills! "
                + "Train and earn experience points by completing challenges!");
        System.out.println("\tLevel up your character to unlock new abilities, increase their strength, "
                + "and become a more formidable force in the game! ");
        System.out.println("\nActions: ");
        System.out.println("\t1. Train");
        System.out.println("\t2. Level up");
        System.out.println("\t3. Gain special ability");
        System.out.println("\t4. Quit academy");
    }

    // REQUIRES: response must be a valid integer input.
    // EFFECTS: Selects and executes the corresponding action based on the user's menu choice.
    private boolean selectSchoolMenu(Character c) {
        System.out.println("Enter a number: ");
        String response = scanner.next();
        if (response.equals("1")) {
            trainingCenter(c);
            return true;
        } else if (response.equals("2")) {
            levelUp(c);
            return true;
        } else if (response.equals("3")) {
            // gainSpecialAbility(c);
            return true;
        } else if (response.equals("4")) {
            return false;
        } else {
            System.out.println("Invalid input!");
            selectSchoolMenu(c);
            return true;
        }
    }

    // EFFECTS: instantiate the 'Trainer' class and run the training session for the user.
    private void trainingCenter(Character c) {
        Trainer trainer = new Trainer("src/randomWords.txt");
        displayIntro();
        runTrainer(trainer);
        calculateResult(c, trainer);
    }

    // EFFECTS: display the introduction of the training session.
    private void displayIntro() {
        System.out.println("\nWelcome to the training session!");
        System.out.println("\tGet ready to sharpen your skills and earn experience points!");
        System.out.println("\tType the words correctly in order to gain experience points.");
        System.out.println("\tPress enter after typing each word to proceed to the next challenge.");
        System.out.println("\tAre you ready? Let's begin!");

        System.out.println("\nPress Enter to start the test.");
        scanner.nextLine();
        scanner.nextLine();
    }

    // MODIFIES: trainer
    // EFFECTS: Generate a set of random word and prompts for user's input, if the input is equal the target, earns one
    // point, or else earns no point.
    private void runTrainer(Trainer trainer) {
        for (int i = 1; i <= 10; i++) {
            String word = trainer.getRandomWord();
            System.out.println("\n" + word + " ");
            String typedWord = scanner.next();
            if (word.equals(typedWord)) {
                System.out.println("You earned one point!");
                trainer.addWordCount();
            } else {
                System.out.println("Oops! You have typed wrong.");
            }
        }
    }


    // EFFECTS: calculate the result of the training game and convert into experience points.
    private void calculateResult(Character c, Trainer trainer) {
        System.out.println("\nTest completed!");
        System.out.println(c.getName() + " has earned " + trainer.getWordCount() + " experience points from training!");
        c.gainExperience(trainer.getWordCount());
        System.out.println("\nPress enter to continue.");
        scanner.nextLine();
        scanner.nextLine();
    }

    private void levelUp(Character c) {
        displayLevelUpMessage();
        completeLevelUp(c);
    }

    private void displayLevelUpMessage() {
        System.out.println("For every 20 experience points, you are able to level up!");
        System.out.println("You are able to earn new abilities once you reach a certain level.");
        System.out.println("Are you ready? Press enter to level up!");
        scanner.nextLine();
        scanner.nextLine();
    }

    private void completeLevelUp(Character c) {
        boolean complete = c.levelUp();
        if (complete) {
            System.out.println("Your character is now Level " + c.getLevel() + "!");
        } else {
            System.out.println("Your character should have at least 20 experience points!");
        }
        System.out.println("Press enter to continue.");
        scanner.nextLine();
    }

//    private void gainSpecialAbility(Character c) {
//        System.out.println("What ability do you want " + c.getName() + " gain?");
//        String ability = scanner.next();
//        switch (ability.toLowerCase()) {
//            case "accelerated healing":
//                System.out.println("\n" + c.getName() + " has gained the special ability: Accelerated Healing!");
//                break;
//            case "resistance":
//                System.out.println("\n" + c.getName() + " has gained the special ability: Resistance!");
//                break;
//            case "swiftness":
//                System.out.println("\n" + c.getName() + " has gained the special ability: Swiftness!");
//                break;
//            default:
//                System.out.println("\nInvalid special ability.");
//        }
//    }
}
