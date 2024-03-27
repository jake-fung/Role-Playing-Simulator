package ui.swing;

import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

// Represents a window for choosing actions whether we want to add, select or remove a character.
public class CharacterLogWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JLabel background;
    private JButton backButton;
    private JButton newCharacter;
    private JButton removeCharacter;
    private JButton savedCharacter;
    private JPanel selectionPanel;
    private JLabel titleLabel;

    // MODIFIES: this
    // EFFECTS: Initializes a new instance of the CharacterLogWindow class
    public CharacterLogWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    // EFFECTS: Initializes and configures the components of the CharacterLogWindow UI.
    private void init() {
        initComponents();
        setWindowProperties();
        configureTitleLabel();
        configureButtons();
        addComponentToSelectionPanel();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    // MODIFITES: this
    // EFFECTS: Instantiates the various components of the CharacterLogWindow UI and initializes their properties.
    private void initComponents() {
        backButton = new JButton();
        selectionPanel = new JPanel();
        titleLabel = new JLabel();
        newCharacter = new JButton();
        savedCharacter = new JButton();
        removeCharacter = new JButton();
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
    // EFFECTS: Sets the text, background color, font properties, alignment, and opacity of the 'titleLabel' component
    //          to create a visually distinct title.
    private void configureTitleLabel() {
        titleLabel.setFont(new Font("Hoefler Text", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("CHOOSE ONE");
        titleLabel.setBackground(new Color(0, 204, 204));
        titleLabel.setOpaque(true);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the buttons for add, select and remove characters, adds action listeners, and configures their
    //          visual states.
    private void configureButtons() {
        newCharacter.setIcon(new ImageIcon("data/pictures/newcharacter.png"));
        addListenerForNewCharacter();
        savedCharacter.setIcon(new ImageIcon("data/pictures/savedcharacter.png"));
        addListenerForSavedCharacter();
        removeCharacter.setIcon(new ImageIcon("data/pictures/removecharacter.png"));
        addListenerForRemoveCharacter();
        configureBackButton();
    }

    // MODIFIES: this
    // EFFECTS: Sets up the button for returning to previous menu, adds action listeners, and
    //          configures their visual states.
    private void configureBackButton() {
        backButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        backButton.setText("BACK");
        add(backButton);
        backButton.setBounds(10, 509, 140, 50);
        backButton.addActionListener(e -> {
            new MainWindow(characterBuilder);
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the newCharacter button.
    private void addListenerForNewCharacter() {
        newCharacter.addActionListener(e -> {
            new NewCharacterWindow(characterBuilder);
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the savedCharacter button.
    private void addListenerForSavedCharacter() {
        savedCharacter.addActionListener(e -> {
            if (characterBuilder.getNumCharacters() != 0) {
                new CharacterSelectionWindow(characterBuilder);
                dispose();
            } else {
                showMessageDialog(this, "You have not created any character yet!");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the removeCharacter button.
    private void addListenerForRemoveCharacter() {
        removeCharacter.addActionListener(e -> {
            if (characterBuilder.getNumCharacters() != 0) {
                new CharacterRemovalWindow(characterBuilder);
                dispose();
            } else {
                showMessageDialog(this, "You have not created any character yet!");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the selectionPanel, using a layout manager to control their positioning
    // and sizing.
    private void addComponentToSelectionPanel() {
        selectionPanel.setBackground(new Color(255, 255, 255));
        GroupLayout selectionPanelLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionPanelLayout);
        setSelectionPanelHorizontalLayout(selectionPanelLayout);
        setSelectionPanelVerticalLayout(selectionPanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the selectionPanel using the provided
    //          GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setSelectionPanelHorizontalLayout(GroupLayout selectionPanelLayout) {
        selectionPanelLayout.setHorizontalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addComponent(titleLabel, -2, 729, -2)
                        .addGroup(selectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(newCharacter)
                                .addGap(10)
                                .addComponent(savedCharacter)
                                .addGap(10)
                                .addComponent(removeCharacter)
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the selectionPanel using the provided
    //          GroupLayout. This involves setting vertical gaps and creating sequential or parallel groups.
    private void setSelectionPanelVerticalLayout(GroupLayout selectionPanelLayout) {
        selectionPanelLayout.setVerticalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, -2, 78, -2)
                                .addGap(25)
                                .addGroup(selectionPanelLayout.createParallelGroup()
                                        .addComponent(newCharacter)
                                        .addComponent(savedCharacter)
                                        .addComponent(removeCharacter)))
        );
    }

    // MODIFIES: this
    // EFFECTS: Adds the components to the JFrame, adjusting their layout properties (e.g., bounds) for proper display.
    private void addComponentsToFrame() {
        add(selectionPanel);
        selectionPanel.setBounds(34, 100, 729, 364);
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
