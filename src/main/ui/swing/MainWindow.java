package ui.swing;

import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

// Represents a window for main menu options
public class MainWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JLabel background;
    private JPanel buttonPanel;
    private JButton loadBuilder;
    private JLabel logo;
    private JButton newBuilder;
    private JButton saveBuilder;
    private JButton quitBuilder;
    private JLabel title;

    // MODIFIES: this
    // EFFECTS: Initializes a new instance of the MainWindow class
    public MainWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    // EFFECTS: Initializes and configures the components of the MainWindow UI.
    private void init() {
        initComponents();
        setWindowProperties();
        configureButtons();
        addComponentsToButtonPanelLayout();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    // MODIFITES: this
    // EFFECTS: Instantiates the various components of the MainWindow UI and initializes their properties.
    private void initComponents() {
        buttonPanel = new JPanel();
        newBuilder = new JButton();
        saveBuilder = new JButton();
        loadBuilder = new JButton();
        quitBuilder = new JButton();
        logo = new JLabel();
        title = new JLabel();
        background = new JLabel();
    }

    // MODIFIES: this
    // EFFECTS: Configures properties of the JFrame window including its default close operation, minimum size,
    //          resizability, and visibility.
    private void setWindowProperties() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the buttons for newBuilder, loadBuilder, saveBuilder and quitBuilder, and adds action listeners
    private void configureButtons() {
        if (characterBuilder.getNumCharacters() == 0) {
            configureButton(newBuilder, "NEW BUILDER");
        } else {
            configureButton(newBuilder, "RESUME BUILDER");
        }
        configureButton(loadBuilder, "LOAD BUILDER");
        configureButton(saveBuilder, "SAVE BUILDER");
        configureButton(quitBuilder, "QUIT BUILDER");

        addListenerForNewBuilder();
        addListenerForSaveBuilder();
        addListenerForLoadBuilder();
        addListenerForQuitBuilder();
    }

    // MODIFIES: this
    // EFFECTS: Sets up the buttons, and configures their visual states.
    private void configureButton(JButton button, String text) {
        button.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        button.setForeground(new Color(0, 102, 102));
        button.setText(text);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the newBuilder button.
    private void addListenerForNewBuilder() {
        newBuilder.addActionListener(e -> {
            new CharacterLogWindow(characterBuilder);
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the loadBuilder button.
    private void addListenerForLoadBuilder() {
        loadBuilder.addActionListener(e -> {
            try {
                characterBuilder.loadCharacters();
                showMessageDialog(this, "Characters loaded suscessfully");
                new CharacterLogWindow(characterBuilder);
                dispose();
            } catch (IOException ioException) {
                showMessageDialog(this, "Characters cannot be loaded suscessfully");
            } catch (RuntimeException runtimeException) {
                showMessageDialog(this, "There is no characters to be loaded. "
                        + "Please start a new game.");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the saveBuilder button.
    private void addListenerForSaveBuilder() {
        saveBuilder.addActionListener(e -> {
            if (characterBuilder.getNumCharacters() == 0) {
                showMessageDialog(this, "There is no character to be saved!");
            } else {
                try {
                    characterBuilder.saveCharacters();
                    showMessageDialog(this, "Characters has been saved!");
                } catch (FileNotFoundException fileNotFoundException) {
                    showMessageDialog(this, "Characters cannot be saved suscessfully.");
                }
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the quitBuilder button.
    private void addListenerForQuitBuilder() {
        quitBuilder.addActionListener(e -> {
            showMessageDialog(this, "Thanks for playing!");
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the buttonPanel, using a layout manager to control their positioning and
    //          sizing.
    private void addComponentsToButtonPanelLayout() {
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GroupLayout(buttonPanel));
        GroupLayout buttonPanelLayout = (GroupLayout) buttonPanel.getLayout();

        setButtonPanelHorizontalLayout(buttonPanelLayout);
        setButtonPanelVerticalLayout(buttonPanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the buttonPanel using the provided
    //          GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setButtonPanelHorizontalLayout(GroupLayout buttonPanelLayout) {
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addGroup(buttonPanelLayout.createParallelGroup()
                                        .addComponent(newBuilder, -2, 270, -2)
                                        .addComponent(saveBuilder, -2, 270, -2)
                                        .addComponent(loadBuilder, -2, 270, -2)
                                        .addComponent(quitBuilder, -2, 270, -2)))
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the buttonPanel using the provided
    //          GroupLayout. This involves setting vertical gaps and creating sequential or parallel groups.
    private void setButtonPanelVerticalLayout(GroupLayout buttonPanelLayout) {
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup()
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(newBuilder, -2, 69, -2)
                                .addGap(5)
                                .addComponent(loadBuilder, -2, 69, -2)
                                .addGap(5)
                                .addComponent(saveBuilder, -2, 69, -2)
                                .addGap(5)
                                .addComponent(quitBuilder, -2, 69, -2)
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Adds the components to the JFrame, adjusting their layout properties (e.g., bounds) for proper display.
    private void addComponentsToFrame() {
        add(buttonPanel);
        buttonPanel.setBounds(280, 240, 270, 310);

        add(logo);
        logo.setIcon(new ImageIcon("data/pictures/logo.png"));
        logo.setPreferredSize(new Dimension(36, 17));
        logo.setBounds(170, 0, 250, 240);

        add(title);
        title.setIcon(new ImageIcon("data/pictures/title.png"));
        title.setBounds(370, 10, 240, 240);

        background.setIcon(new ImageIcon("data/pictures/Background.png"));
        add(background);
        background.setBounds(0, 0, 800, 617);
    }

    // MODIFIES: this
    // EFFECTS: Calculates the appropriate coordinates to position the JFrame in the center of the
    //          user's screen and sets the frame's location accordingly.
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

}
