package ui;

import java.util.Scanner;

// The MainUI class serves as a main ui for starting the whole application.
public class MainUI {
    private final Scanner scanner;

    // EFFECTS: construct the 'MainUI' class and initializes the 'scanner' fields.
    public MainUI() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        runTitle();
    }

    // EFFECTS: display the title screen.
    public void runTitle() {
        System.out.println("\nWelcome to RPG Character Builder!");
        System.out.println("\nIt features an interactive application where players can customize their own unique "
                + "characters, including appearance, personality, and skills, and then guide them through a series of "
                + "challenges in the school to unlock and develop special abilities!");
        System.out.println("\nPress enter to play.");
        scanner.nextLine();
        new CharacterUI();
    }

}
