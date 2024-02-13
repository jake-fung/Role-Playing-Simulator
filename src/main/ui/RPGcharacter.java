package ui;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RPGcharacter {
    private final ArrayList<Character> characterLog;
    private final Scanner scanner;
    private String name;
    private boolean isMale;
    private int rpClass;

    public RPGcharacter() {
        characterLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        runTitle();
    }

    public void runTitle() {
        System.out.println("Welcome to RPG Character Builder!\n");
        System.out.println("It features an interactive application in which you can create your own unique characters"
                + "\nand train them in school to earn special abilities!");
        runMainMenu();
    }

    /********************************************
     * This is where we run the main menu of the application *
     ********************************************/

    // EFFECTS: Initiates the main menu loop where users can choose different actions.
    public void runMainMenu() {
        String response;
        while (true) {
            displayMenu();
            response = scanner.next();
            selectMenu(response);
        }
    }

    // EFFECTS: Displays the main menu options to the user.
    public void displayMenu() {
        System.out.println("\nActions: ");
        System.out.println("\t1 -> New Character");
        System.out.println("\t2 -> Saved Characters");
        System.out.println("\t3 -> Quit");
        System.out.println("Enter a number:");
    }

    // REQUIRES: response must be a valid integer input.
    // EFFECTS: Selects and executes the corresponding action based on the user's menu choice.
    public void selectMenu(String response) {
        if (response.equals("1")) {
            characterBuilder();
        } else if (response.equals("2")) {
            if (characterLog.size() != 0) {
                savedCharacter();
            } else {
                System.out.println("There is no existing character available!");
            }
        } else if (response.equals("3")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        } else {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    /********************************************
     * This is where we run the character builder after selecting 1 in the main menu *
     ********************************************/

    // EFFECTS: Initiates the character creation process, allowing users to create a new character.
    public void characterBuilder() {
        do {
            chooseName();
            chooseGender();
            chooseClass();
            confirmInfo();
        } while (confirmCreate());
        createCharacter();
        System.out.println("Character created successfully!");
    }


    // MODIFIES: this
    // EFFECTS: choose a name for the character.
    public void chooseName() {
        System.out.println("\nPlease choose a name for your character: ");
        name = scanner.next();
        System.out.println("Welcome " + name + "!");
    }

    // MODIFIES: this
    // EFFECTS: choose a gender for the character.
    public void chooseGender() {
        String response;

        System.out.println("\nIs " + name + " a male or female? (M/F)");
        response = scanner.next();
        response = response.toUpperCase();
        switch (response) {
            case "M":
                System.out.println("Your character is a male.");
                isMale = true;
                break;
            case "F":
                System.out.println("Your character is a female.");
                isMale = false;
                break;
            default:
                System.out.println("Invalid input!");
                chooseGender();
                break;
        }

    }

    // MODIFIES: this
    // EFFECTS: choose a class for the character, return 0 for barbarians, 1 for knights
    // 2 for rangers.
    public void chooseClass() {
        System.out.println("\nChoose a class for " + name + ".");
        System.out.println("\t1 -> Barbarians");
        System.out.println("\t2 -> Knights");
        System.out.println("\t3 -> Rangers");
        System.out.println("Enter a number: ");
        String response = scanner.next();
        if (response.equals("1")) {
            System.out.println("You choose barbarians!");
            rpClass = 0;
        } else if (response.equals("2")) {
            System.out.println("You choose knights!");
            rpClass = 1;
        } else if (response.equals("3")) {
            System.out.println("You choose rangers!");
            rpClass = 2;
        } else {
            System.out.println("There is no such class! Choose again.");
            chooseClass();
        }
    }

    // EFFECTS: Displays the review of the character's information for confirmation.
    public void confirmInfo() {
        System.out.println("\nReview your characters!");
        System.out.println("\tName: " + name);
        System.out.println("\tGender: " + (isMale ? "Male" : "Female"));
        if (rpClass == 0) {
            System.out.println("\tClass: Barbarian");
        } else if (rpClass == 1) {
            System.out.println("\tClass: Knight");
        } else {
            System.out.println("\tClass: Ranger");
        }
    }

    // EFFECTS: Prompts the user to confirm if they wish to continue character creation.
    public boolean confirmCreate() {
        String confirm;

        System.out.println("\nDo you wish to continue? (Y/N)");
        confirm = scanner.next();
        confirm = confirm.toUpperCase();
        if (confirm.equals("Y")) {
            return false;
        } else if (confirm.equals("N")) {
            return true;
        }
        System.out.println("Invalid input. It should be Y or N.");
        return confirmCreate();
    }

    // MODIFIES: this
    // EFFECTS: Creates a new character based on the user's choices and adds it to the character log.
    private void createCharacter() {
        Character character;
        if (rpClass == 0) {
            character = new Barbarian(name, isMale);
        } else if (rpClass == 1) {
            character = new Knight(name, isMale);
        } else {
            character = new Ranger(name, isMale);
        }
        characterLog.add(character);
    }

    /********************************************
     * This is where we run the saved characters option after selecting 2 in the main menu *
     ********************************************/

    public void savedCharacter() {
        displayCharacters();
        Character selectedCharacter = selectCharacter();
        System.out.println("You selected: " + selectedCharacter.getName());
        new RPGschool(selectedCharacter);
    }

    public void displayCharacters() {
        System.out.println("Select a character:");
        for (int i = 0; i < characterLog.size(); i++) {
            System.out.println((i + 1) + ". " + characterLog.get(i).getName());
        }

    }

    public Character selectCharacter() {
        System.out.print("Enter the number of the character you want to select: ");
        int choice = scanner.nextInt();
        try {
            if (choice >= 1 && choice <= characterLog.size()) {
                return characterLog.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Please select a valid character.");
                return selectCharacter();
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number!");
            return selectCharacter();
        }
    }
}
