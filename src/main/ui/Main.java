package ui;

import ui.swing.MainWindow;
import ui.swing.simulator.CharacterBuilder;

public class Main {
    public static void main(String[] args) {
        new MainWindow(new CharacterBuilder());
    }
}
