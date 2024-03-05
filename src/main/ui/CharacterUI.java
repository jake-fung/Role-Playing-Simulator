package ui;

import model.*;
import model.Character;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// The CharacterUI class represents a CUI interface for a character in a role-playing game (RPG).
// It serves as a main ui for creating a character and selecting a character.
public class CharacterUI {
    private static final String JSON_STORE = "./data/characterlog.json";
    private CharacterLog characterLog;
    private final Scanner scanner;
    private String name;
    private boolean isMale;
    private int rpClass;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: Constructs a new `CharacterUI` object and initializes the `characterLog` and `scanner` fields.
    public CharacterUI() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        characterLog = new CharacterLog();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runCharacterUI();
    }

    // EFFECTS: Initiates the main menu loop where users can choose different actions.
    private void runCharacterUI() {
        String response;
        while (true) {
            displayCharacterLogMenu();
            response = scanner.next();
            selectCharacterLogMenu(response);
        }
    }

    // EFFECTS: Display the main menu options for the user to choose a new builder or use a saved builder.
    private void displayCharacterLogMenu() {
        System.out.println("\nActions: ");
        System.out.println("\t1 -> New Builder");
        System.out.println("\t2 -> Load Previous Builder");
        System.out.println("\t3 -> Save Current Builder");
        System.out.println("\t4 -> Quit");
        System.out.println("Enter a number:");
    }

    // REQUIRES: response must be a valid integer input.
    // EFFECTS: Selects and executes the corresponding action based on the user's menu choice.
    private void selectCharacterLogMenu(String response) {
        if (response.equals("1")) {
            characterMenu();
        } else if (response.equals("2")) {
            loadCharacterLog();
        } else if (response.equals("3")) {
            saveCharacterLog();
        } else if (response.equals("4")) {
            System.out.println("\nThanks for playing!");
            System.exit(0);
        } else {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    // EFFECTS: Initiates the character menu loop where users can choose different actions.
    private void characterMenu() {
        String response;
        while (true) {
            displayCharacterMenu();
            response = scanner.next();
            selectCharacterMenu(response);
        }
    }

    // EFFECTS: Displays the character menu options to the user after choosing to use a new builder or saved builder.
    private void displayCharacterMenu() {
        System.out.println("\nActions: ");
        System.out.println("\t1 -> New Character");
        System.out.println("\t2 -> Saved Characters");
        System.out.println("\t3 -> Remove Character");
        System.out.println("\t4 -> Return to Main Menu");
        System.out.println("Enter a number:");
    }

    // REQUIRES: response must be a valid integer input.
    // EFFECTS: Selects and executes the corresponding action based on the user's menu choice.
    private void selectCharacterMenu(String response) {
        if (response.equals("1")) {
            characterBuilder();
        } else if (response.equals("2")) {
            if (characterLog.getNumCharacters() != 0) {
                savedCharacter();
            } else {
                System.out.println("There is no existing character available!");
            }
        } else if (response.equals("3")) {
            if (characterLog.getNumCharacters() != 0) {
                removeCharacter();
            } else {
                System.out.println("There is no existing character available!");
            }
        } else if (response.equals("4")) {
            runCharacterUI();
        } else {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    /********************************************
     * This is where we run the character builder after selecting 1 in the main menu *
     ********************************************/

    // EFFECTS: Initiates the character creation process, allowing users to create a new character.
    private void characterBuilder() {
        do {
            chooseName();
            chooseGender();
            chooseClass();
            confirmInfo();
        } while (confirmCreate());
        createCharacter();
        System.out.println("\nCharacter created successfully!");
        System.out.println("\nPress enter to continue.");
        scanner.nextLine();
        scanner.nextLine();
    }


    // MODIFIES: this
    // EFFECTS: choose a name for the character.
    private void chooseName() {
        System.out.println("\nPlease choose a name for your character: ");
        name = scanner.next();
        System.out.println("Welcome " + name + "!");
    }

    // MODIFIES: this
    // EFFECTS: choose a gender for the character.
    private void chooseGender() {
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
    private void chooseClass() {
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
    private void confirmInfo() {
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
    private boolean confirmCreate() {
        String confirm;

        System.out.println("\nDo you wish to continue? (Y/N)");
        confirm = scanner.next();
        confirm = confirm.toUpperCase();
        if (confirm.equals("Y")) {
            return false;
        } else if (confirm.equals("N")) {
            return true;
        } else {
            System.out.println("Invalid input. It should be Y or N.");
            return confirmCreate();
        }
    }

    // MODIFIES: this
    // EFFECTS: Creates a new character based on the user's choices and adds it to the character log.
    private void createCharacter() {
        Character character;
        if (rpClass == 0) {
            character = new Barbarian();
        } else if (rpClass == 1) {
            character = new Knight();
        } else {
            character = new Ranger();
        }
        character.setName(name);
        character.setIsMale(isMale);
        characterLog.addCharacter(character);
    }

    /********************************************
     * This is where we display the saved characters after selecting 2 or 3 in the main menu *
     ********************************************/

    // EFFECTS: display the list of characters available in the character log.
    private void displayCharacters() {
        System.out.println("\nCreated characters:");
        for (int i = 0; i < characterLog.getNumCharacters(); i++) {
            System.out.println((i + 1) + ". " + characterLog.getCharacter(i).getName());
        }
    }

    /********************************************
     * This is where we run the procedure after selecting 2 in the main menu *
     ********************************************/

    // EFFECTS: Display the list of saved characters and initializes a new SchoolUI object.
    private void savedCharacter() {
        displayCharacters();
        Character selectedCharacter = selectCharacter();
        System.out.println("\nYou selected: " + selectedCharacter.getName());
        new SchoolUI(selectedCharacter);
    }

    // REQUIRES: choice should be a valid input of integer.
    // EFFECTS: select a character based on user's input.
    private Character selectCharacter() {
        System.out.print("\nEnter a number of the character you want to select: ");
        int choice = scanner.nextInt();
        if (characterLog.getCharacter(choice - 1) != null) {
            return characterLog.getCharacter(choice - 1);
        } else {
            System.out.println("There is no such character! Choose again.");
            return selectCharacter();
        }
    }

    /********************************************
     * This is where we run the procedure after selecting 3 in the main menu *
     ********************************************/

    // REQUIRES: choice should be a valid input of integer.
    // MODIFIES: this
    // EFFECTS: removes a character based on user's input.
    private void removeCharacter() {
        displayCharacters();
        System.out.print("\nEnter a number of the character you want to remove: ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= characterLog.getNumCharacters()) {
            String name = characterLog.getCharacter(choice - 1).getName();
            boolean confirm = confirmRemove(name);
            if (confirm) {
                characterLog.removeCharacter(choice - 1);
                System.out.println(name + " successfully removed.");
                System.out.println("\nPress enter to continue.");
                scanner.nextLine();
                scanner.nextLine();
            }
        } else {
            System.out.println("There is no such character! Choose again");
            removeCharacter();
        }
    }

    // EFFECTS: returns true if the user input "Y" to confirm removing the character.
    private boolean confirmRemove(String name) {
        System.out.println("\nWARNING: NOTE THAT CHANGES CANNOT BE REVERTED. ALL DATA WILL BE LOST.");
        System.out.println("Are you sure to remove " + name + "? (Y/N)");
        String response = scanner.next();
        response = response.toUpperCase();
        if (response.equals("Y")) {
            return true;
        } else if (response.equals("N")) {
            return false;
        } else {
            System.out.println("Invalid input. It should be Y or N.");
            return confirmCreate();
        }
    }

    // Method taken from WorkRoomApp class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves the CharacterLog to file
    private void loadCharacterLog() {
        try {
            characterLog = jsonReader.read();
            System.out.println("Loaded your saved builder from " + JSON_STORE + "!");
            characterMenu();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // Method taken from WorkRoomApp class in
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads CharacterLog from file
    private void saveCharacterLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(characterLog);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE + "!");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}

