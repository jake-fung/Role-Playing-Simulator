package ui.swing;

import model.Character;
import model.Classes;
import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;

// Represents a window for showing the info of a selected character.
public class CharacterSelectedWindow extends JFrame {
    private final Character character;
    private final CharacterBuilder characterBuilder;
    private JLabel attackPowerLabel;
    private JButton backButton;
    private JLabel background;
    private JPanel characterInfoPanel;
    private JLabel characterPhoto;
    private JPanel characterSelectedPanel;
    private JLabel classLabel;
    private JLabel defensePowerLabel;
    private JLabel expLabel;
    private JLabel genderLabel;
    private JLabel healthLabel;
    private JLabel levelLabel;
    private JLabel nameLabel;
    private JLabel titleLabel;

    // MODIFIES: this
    // EFFECTS: Initializes a new instance of the CharacterSelectedWindow class
    public CharacterSelectedWindow(Character character, CharacterBuilder characterBuilder) {
        this.character = character;
        this.characterBuilder = characterBuilder;
        init();
    }

    // EFFECTS: Initializes and configures the components of the CharacterSelectedWindow UI.
    private void init() {
        initComponents();
        setWindowProperties();
        configureBackButton();
        configureCharacterPhoto();
        configureTitleLabel();
        configureCharacterInfoLabels();
        addComponentToCharacterInfoPanel();
        addComponentToCharacterSelectedPanel();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    // MODIFITES: this
    // EFFECTS: Instantiates the various components of the CharacterSelectedWindow UI and initializes their properties.
    private void initComponents() {
        backButton = new JButton();
        characterSelectedPanel = new JPanel();
        titleLabel = new JLabel();
        characterPhoto = new JLabel();
        characterInfoPanel = new JPanel();
        nameLabel = new JLabel();
        genderLabel = new JLabel();
        classLabel = new JLabel();
        expLabel = new JLabel();
        levelLabel = new JLabel();
        healthLabel = new JLabel();
        attackPowerLabel = new JLabel();
        defensePowerLabel = new JLabel();
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
    // EFFECTS: Sets up the button for returning to previous menu, adds action listeners, and
    //          configures their visual states.
    private void configureBackButton() {
        backButton.setFont(new Font("Hoefler Text", Font.BOLD, 36));
        backButton.setText("BACK");
        add(backButton);
        backButton.setBounds(20, 535, 420, 50);
        backButton.addActionListener(e -> {
            new CharacterSelectionWindow(characterBuilder);
            dispose();
        });
    }

    // MODIFIES: this
    // EFFECTS: Display images according to the character's class.
    private void configureCharacterPhoto() {
        if (character.getClasses() == Classes.Barbarian) {
            characterPhoto.setIcon(new ImageIcon("data/pictures/barbarian.png"));
        } else if (character.getClasses() == Classes.Knight) {
            characterPhoto.setIcon(new ImageIcon("data/pictures/knight.png"));
        } else {
            characterPhoto.setIcon(new ImageIcon("data/pictures/ranger.png"));
        }
    }

    // MODIFIES: this
    // EFFECTS: Sets the text, background color, font properties, alignment, and opacity of the 'titleLabel' component
    //          to create a visually distinct title.
    private void configureTitleLabel() {
        titleLabel.setBackground(new Color(0, 204, 204));
        titleLabel.setFont(new Font("Hoefler Text", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("YOUR CHARACTER");
        titleLabel.setOpaque(true);
        titleLabel.setSize(new Dimension(420, 92));
    }

    // MODIFIES: this
    // EFFECTS: Sets the text, font properties, and size of the label components.
    private void configureCharacterInfoLabels() {
        nameLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        nameLabel.setText("Name: " + character.getName());

        genderLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        genderLabel.setText("Sex: " + (character.getIsMale() ? "Male" : "Female"));

        classLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        classLabel.setText("Class: " + character.getClasses());

        expLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        expLabel.setText("Experience: " + character.getExperience());

        levelLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        levelLabel.setText("Level: " + character.getLevel());

        healthLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        healthLabel.setText("Health: " + character.getHealth());

        attackPowerLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        attackPowerLabel.setText("Attack Power: " + character.getAttackPower());

        defensePowerLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        defensePowerLabel.setText("Defense Power: " + character.getDefensePower());
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the characterInfoPanel, using a layout manager to control their
    //          positioning and sizing.
    private void addComponentToCharacterInfoPanel() {
        characterInfoPanel.setOpaque(false);
        GroupLayout characterInfoPanelLayout = new GroupLayout(characterInfoPanel);
        characterInfoPanel.setLayout(characterInfoPanelLayout);
        setCharacterInfoPanelHorizontalLayout(characterInfoPanelLayout);
        setCharacterInfoPanelVerticalLayout(characterInfoPanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the characterInfoPanel using the provided
    // GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setCharacterInfoPanelHorizontalLayout(GroupLayout characterInfoPanelLayout) {
        characterInfoPanelLayout.setHorizontalGroup(
                characterInfoPanelLayout.createParallelGroup()
                        .addGroup(characterInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(characterInfoPanelLayout.createParallelGroup()
                                        .addComponent(expLabel)
                                        .addComponent(genderLabel)
                                        .addComponent(nameLabel)
                                        .addComponent(classLabel)
                                        .addComponent(levelLabel)
                                        .addComponent(healthLabel)
                                        .addComponent(attackPowerLabel)
                                        .addComponent(defensePowerLabel))
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the characterInfoPanel using the provided
    // roupLayout. This involves setting vertical gaps and creating sequential or parallel groups.
    private void setCharacterInfoPanelVerticalLayout(GroupLayout characterInfoPanelLayout) {
        characterInfoPanelLayout.setVerticalGroup(
                characterInfoPanelLayout.createParallelGroup()
                        .addGroup(characterInfoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addGap(8)
                                .addComponent(genderLabel)
                                .addGap(8)
                                .addComponent(classLabel)
                                .addGap(8)
                                .addComponent(expLabel)
                                .addGap(8)
                                .addComponent(levelLabel)
                                .addGap(8)
                                .addComponent(healthLabel)
                                .addGap(8)
                                .addComponent(attackPowerLabel)
                                .addGap(8)
                                .addComponent(defensePowerLabel)
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the characterSelectedPanel, using a layout manager to control their
    // positioning and sizing.
    private void addComponentToCharacterSelectedPanel() {
        characterSelectedPanel.setBackground(new Color(255, 255, 255));
        GroupLayout characterSelectedPanelLayout = new GroupLayout(characterSelectedPanel);
        characterSelectedPanel.setLayout(characterSelectedPanelLayout);
        characterSelectedPanelLayout.setHorizontalGroup(
                characterSelectedPanelLayout.createParallelGroup()
                        .addComponent(titleLabel, -2, 420, -2)
                        .addGroup(characterSelectedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(characterSelectedPanelLayout.createParallelGroup()
                                        .addComponent(characterPhoto, -2, 408, -2)
                                        .addComponent(characterInfoPanel))
                                .addContainerGap())
        );
        characterSelectedPanelLayout.setVerticalGroup(
                characterSelectedPanelLayout.createParallelGroup()
                        .addGroup(characterSelectedPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, -2, 92, -2)
                                .addGap(5)
                                .addComponent(characterPhoto, -2, 116, -2)
                                .addGap(15)
                                .addComponent(characterInfoPanel))
        );
    }

    // MODIFIES: this
    // EFFECTS: Adds the components to the JFrame, adjusting their layout properties (e.g., bounds) for proper display.
    private void addComponentsToFrame() {
        add(characterSelectedPanel);
        characterSelectedPanel.setBounds(20, 20, 420, 510);

        background.setIcon(new ImageIcon("data/pictures/characterselectedbackground.png"));
        add(background);
        background.setBounds(0, 0, 803, 618);
    }

    // MODIFIES: this
    // EFFECTS: Calculates the appropriate coordinates to position the JFrame in the center of the
    //          user's screen and sets the frame's location accordingly.
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }


}
