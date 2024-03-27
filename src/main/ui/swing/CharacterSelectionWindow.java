package ui.swing;

import model.Character;
import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

// Represents a window for selecting a character in a character list
public class CharacterSelectionWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JButton backButton;
    private JLabel background;
    private JList<String> characterList;
    private JScrollPane characterScrollPane;
    private JPanel characterSelectionPanel;
    private JButton selectButton;
    private JPanel selectionPanel;
    private JLabel titleLabel;

    // MODIFIES: this
    // EFFECTS: Initializes a new instance of the CharacterSelectionWindow class
    public CharacterSelectionWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    // EFFECTS: Initializes and configures the components of the CharacterSelectionWindow UI.
    private void init() {
        initComponents();
        setWindowProperties();
        configureTitleLabel();
        configureCharacterMenu();
        configureButtons();
        addComponentToSelectionPanel();
        addComponentToCharacterSelectionPanel();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    // MODIFITES: this
    // EFFECTS: Instantiates the various components of the CharacterSelectionWindow UI and initializes their properties.
    private void initComponents() {
        characterSelectionPanel = new JPanel();
        titleLabel = new JLabel();
        characterScrollPane = new JScrollPane();
        selectionPanel = new JPanel();
        selectButton = new JButton();
        backButton = new JButton();
        background = new JLabel();
    }

    // MODIFIES: this
    // EFFECTS: Configures properties of the JFrame window including its default close operation, minimum size,
    //          resizability, and visibility.
    private void setWindowProperties() {
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: Sets the text, background color, font properties, alignment, and opacity of the 'titleLabel' component
    //          to create a visually distinct title.
    private void configureTitleLabel() {
        titleLabel.setBackground(new Color(0, 204, 204));
        titleLabel.setFont(new Font("Hoefler Text", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("SELECT YOUR CHARACTER");
        titleLabel.setOpaque(true);
    }

    // MODIFIES: this
    // EFFECTS:  Fetches a list of characters from the characterBuilder, creates an array of character names, constructs
    //           a JList using that array, sets visual properties of the JList, and associates the JList with the
    //           characterScrollPane.
    private void configureCharacterMenu() {
        ArrayList<Character> characterArrayList = characterBuilder.getCharacters();
        String[] charactersArray = new String[characterArrayList.size()];
        for (int i = 0; i < characterArrayList.size(); i++) {
            charactersArray[i] = characterArrayList.get(i).getName();
        }
        characterList = new JList<>(charactersArray);
        characterList.setFont(new Font("Hoefler Text", Font.PLAIN, 24));
        characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        characterScrollPane.setViewportView(characterList);
    }

    // MODIFIES: this
    // EFFECTS: Sets up the buttons for character selection and return to previous menu, adds action listeners, and
    //          configures their visual states.
    private void configureButtons() {
        selectButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        selectButton.setText("SELECT");
        addActionListenerForSelectButton();

        backButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        backButton.setText("BACK");
        backButton.addActionListener(e -> {
            new CharacterLogWindow(characterBuilder);
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListener to the select button.
    private void addActionListenerForSelectButton() {
        selectButton.addActionListener(e -> {
            if (characterList.getSelectedIndex() != -1) {
                Character character = characterBuilder.getCharacter(characterList.getSelectedIndex());
                new CharacterSelectedWindow(character, characterBuilder);
                dispose();
            } else {
                showMessageDialog(this, "Select a character to select.");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the selectionPanel, using a layout manager to control their positioning
    //          and sizing.
    private void addComponentToSelectionPanel() {
        GroupLayout selectionPanelLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionPanelLayout);
        selectionPanelLayout.setHorizontalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton, -2, 228, -2)
                                .addGap(245)
                                .addComponent(selectButton, -2, 223, -2)
                                .addContainerGap())
        );
        selectionPanelLayout.setVerticalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createParallelGroup()
                                .addComponent(selectButton, -2, 52, -2)
                                .addComponent(backButton, -2, 52, -2))
        );

    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the characterSelectionPanel, using a layout manager to control their
    //          positioning and sizing.
    private void addComponentToCharacterSelectionPanel() {
        characterSelectionPanel.setBackground(new Color(255, 255, 255));
        GroupLayout characterSelectionPanelLayout = new GroupLayout(characterSelectionPanel);
        characterSelectionPanel.setLayout(characterSelectionPanelLayout);
        characterSelectionPanelLayout.setHorizontalGroup(
                characterSelectionPanelLayout.createParallelGroup()
                        .addComponent(titleLabel, -2, 720, -2)
                        .addComponent(characterScrollPane, -2, 720, -2)
                        .addComponent(selectionPanel, -2, 720, -2)
        );
        characterSelectionPanelLayout.setVerticalGroup(
                characterSelectionPanelLayout.createParallelGroup()
                        .addGroup(characterSelectionPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, -2, 88, -2)
                                .addGap(10)
                                .addComponent(characterScrollPane, -2, 331, -2)
                                .addGap(5)
                                .addComponent(selectionPanel)
                        )
        );
    }

    // MODIFIES: this
    // EFFECTS: Adds the components to the JFrame, adjusting their layout properties (e.g., bounds) for proper display.
    private void addComponentsToFrame() {
        add(characterSelectionPanel);
        characterSelectionPanel.setBounds(40, 60, 720, 490);

        background.setIcon(new ImageIcon("data/pictures/characterbackground.png"));
        background.setBounds(new Rectangle(0, 0, 800, 617));
        add(background);
        background.setBounds(0, 0, 800, 618);
    }

    // MODIFIES: this
    // EFFECTS: Calculates the appropriate coordinates to position the JFrame in the center of the
    //          user's screen and sets the frame's location accordingly.
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }
}
