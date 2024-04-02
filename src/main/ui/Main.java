package ui;

import model.Event;
import model.EventLog;
import ui.swing.MainWindow;
import ui.swing.simulator.CharacterBuilder;

public class Main {
    public static void main(String[] args) {
        new MainWindow(new CharacterBuilder());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            EventLog eventLog = EventLog.getInstance();
            for (Event event : eventLog) {
                System.out.println(event.toString() + "\n");
            }
        }));
    }
}
