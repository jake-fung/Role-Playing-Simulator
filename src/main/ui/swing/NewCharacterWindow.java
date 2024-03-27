package ui.swing;

import model.Classes;
import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

// Represents a window for creating a new character.
public class NewCharacterWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JButton backButton;
    private JLabel background;
    private JButton barbarianButton;
    private JPanel classPanel;
    private JPanel confirmPanel;
    private JButton createButton;
    private JButton femaleButton;
    private JPanel genderPanel;
    private JButton knightButton;
    private JButton maleButton;
    private JTextField nameTextField;
    private JPanel namePanel;
    private JPanel newCharacterPanel;
    private JButton rangerButton;
    private JLabel titleLabel;
    private JLabel nameLabel;
    private Boolean isMale;
    private Classes classes;
    private String characterName;

    // MODIFIES: this
    // EFFECTS: Initializes a new instance of the NewCharacterWindow class
    public NewCharacterWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    // EFFECTS: Initializes and configures the components of the NewCharacterWindow UI.
    private void init() {
        initComponents();
        setWindowProperties();
        configureTitleLabel();
        configureComponentsInNamePanel();
        configureButtons();
        addComponentToNamePanel();
        addComponentToGenderPanel();
        addComponentToClassPanel();
        addComponentToConfirmPanel();
        addComponentToNewCharacterPanel();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    // MODIFITES: this
    // EFFECTS: Instantiates the various components of the NewCharacterWindow UI and initializes their properties.
    private void initComponents() {
        newCharacterPanel = new JPanel();
        titleLabel = new JLabel();
        namePanel = new JPanel();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        genderPanel = new JPanel();
        maleButton = new JButton();
        femaleButton = new JButton();
        classPanel = new JPanel();
        barbarianButton = new JButton();
        knightButton = new JButton();
        rangerButton = new JButton();
        confirmPanel = new JPanel();
        backButton = new JButton();
        createButton = new JButton();
        background = new JLabel();
        classes = null;
        isMale = null;
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
        titleLabel.setBackground(new Color(0, 204, 204));
        titleLabel.setFont(new Font("Hoefler Text", Font.PLAIN, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("CREATE YOUR CHARACTER");
        titleLabel.setOpaque(true);
    }

    // MODIFIES: this
    // EFFECTS: Sets the font and potentially other visual properties of the nameLabel and nameTextField components,
    // for the purpose of styling the name input section.
    private void configureComponentsInNamePanel() {
        nameLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        nameLabel.setText("Your name:");

        nameTextField.setFont(new Font("Hoefler Text", Font.PLAIN, 24));
    }

    // MODIFIES: this
    // EFFECTS: Sets up the buttons for gender and class selection, adds action listeners, and configures their visual
    //          states.
    private void configureButtons() {
        maleButton.setIcon(new ImageIcon("data/pictures/malebutton.png"));
        femaleButton.setIcon(new ImageIcon("data/pictures/femalebutton.png"));
        addActionListenerForGenderButton();

        barbarianButton.setIcon(new ImageIcon("data/pictures/barbarianbutton.png"));
        knightButton.setIcon(new ImageIcon("data/pictures/knightbutton.png"));
        rangerButton.setIcon(new ImageIcon("data/pictures/rangerbutton.png"));
        addActionListenerForBarbarianButton();
        addActionListenerForKnightButton();
        addActionListenerForRangerButton();

        backButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        backButton.setText("BACK");
        backButton.addActionListener(e -> {
            new CharacterLogWindow(characterBuilder);
            dispose();
        });

        createButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        createButton.setText("CREATE");
        addActionListenerForCreateButton();
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListeners to the gender buttons. When triggered, the listeners update the visual
    //          representation of the selected gender (e.g., darkening the selected button) and set the value of the
    //          isMale instance variable accordingly.
    private void addActionListenerForGenderButton() {
        maleButton.addActionListener(e -> {
            if (maleButton.isEnabled()) {
                maleButton.setIcon(new ImageIcon("data/pictures/malebuttondarkened.png"));
            }
            femaleButton.setIcon(new ImageIcon("data/pictures/femalebutton.png"));
            isMale = true;
        });
        femaleButton.addActionListener(e -> {
            if (femaleButton.isEnabled()) {
                femaleButton.setIcon(new ImageIcon("data/pictures/femalebuttondarkened.png"));
            }
            maleButton.setIcon(new ImageIcon("data/pictures/malebutton.png"));
            isMale = false;
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListeners to the barbarian button. When triggered, the listeners update the visual
    //          representation of the selected class (e.g., darkening the selected button) and set the value of the
    //          class instance variable accordingly.
    private void addActionListenerForBarbarianButton() {
        barbarianButton.addActionListener(e -> {
            if (barbarianButton.isEnabled()) {
                barbarianButton.setIcon(new ImageIcon("data/pictures/barbarianbuttondarkened.png"));
            }
            knightButton.setIcon(new ImageIcon("data/pictures/knightbutton.png"));
            rangerButton.setIcon(new ImageIcon("data/pictures/rangerbutton.png"));
            classes = Classes.Barbarian;
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListeners to the knight button. When triggered, the listeners update the visual
    //          representation of the selected class (e.g., darkening the selected button) and set the value of the
    //          class instance variable accordingly.
    private void addActionListenerForKnightButton() {
        knightButton.addActionListener(e -> {
            if (knightButton.isEnabled()) {
                knightButton.setIcon(new ImageIcon("data/pictures/knightbuttondarkened.png"));
            }
            barbarianButton.setIcon(new ImageIcon("data/pictures/barbarianbutton.png"));
            rangerButton.setIcon(new ImageIcon("data/pictures/rangerbutton.png"));
            classes = Classes.Knight;
        });
    }

    // MODIFIES: this
    // EFFECTS: Adds ActionListeners to the ranger button. When triggered, the listeners update the visual
    //          representation of the selected class (e.g., darkening the selected button) and set the value of the
    //          class instance variable accordingly.
    private void addActionListenerForRangerButton() {
        rangerButton.addActionListener(e -> {
            if (rangerButton.isEnabled()) {
                rangerButton.setIcon(new ImageIcon("data/pictures/rangerbuttondarkened.png"));
            }
            knightButton.setIcon(new ImageIcon("data/pictures/knightbutton.png"));
            barbarianButton.setIcon(new ImageIcon("data/pictures/barbarianbutton.png"));
            classes = Classes.Ranger;
        });
    }

    // MODIFIES: this
    // EFFECTS: Attempts to create a new character with the provided details. If successful, displays a message, and
    //          transitions to the CharacterLogWindow. Otherwise, displays an error message.
    private void addActionListenerForCreateButton() {
        createButton.addActionListener(e -> {
            characterName = nameTextField.getText();
            if ((characterName != null) && (classes != null) && (isMale != null)) {
                characterBuilder.createCharacter(characterName, isMale, classes);
                showMessageDialog(this, characterName + " has been created sucessfully!");
                new CharacterLogWindow(characterBuilder);
                dispose();
            } else {
                showMessageDialog(this, "Please select a name, gender and class!");
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the namePanel, using a layout manager to control their positioning and
    //          sizing.
    private void addComponentToNamePanel() {
        GroupLayout namePanelLayout = new GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        setNamePanelHorizontalLayout(namePanelLayout);
        setNamePanelVerticalLayout(namePanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the namePanel using the provided
    //          GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setNamePanelHorizontalLayout(GroupLayout namePanelLayout) {
        namePanelLayout.setHorizontalGroup(
                namePanelLayout.createParallelGroup()
                        .addGroup(namePanelLayout.createSequentialGroup()
                                .addGap(19)
                                .addComponent(nameLabel, -2, 210, -2)
                                .addGap(10)
                                .addComponent(nameTextField, -2, 365, -2)
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the namePanel using the provided GroupLayout.
    //          This involves setting vertical gaps and creating sequential or parallel groups.
    private void setNamePanelVerticalLayout(GroupLayout namePanelLayout) {
        namePanelLayout.setVerticalGroup(
                namePanelLayout.createParallelGroup()
                        .addGroup(namePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(namePanelLayout.createParallelGroup()
                                        .addComponent(nameLabel, -2, 71, -2)
                                        .addComponent(nameTextField, -2, 45, -2)))
        );
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the genderPanel, using a layout manager to control their positioning and
    //          sizing.
    private void addComponentToGenderPanel() {
        GroupLayout genderPanelLayout = new GroupLayout(genderPanel);
        genderPanel.setLayout(genderPanelLayout);
        genderPanelLayout.setHorizontalGroup(
                genderPanelLayout.createParallelGroup()
                        .addGroup(genderPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(maleButton, -2, 340, -2)
                                .addGap(14)
                                .addComponent(femaleButton, -2, 340, -2)
                                .addContainerGap())
        );
        genderPanelLayout.setVerticalGroup(
                genderPanelLayout.createParallelGroup()
                        .addGroup(genderPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(genderPanelLayout.createParallelGroup()
                                        .addComponent(maleButton, -2, 136, -2)
                                        .addComponent(femaleButton, -2, 136, -2))
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the namePanel, using a layout manager to control their positioning and
    //          sizing.
    private void addComponentToClassPanel() {
        GroupLayout classPanelLayout = new GroupLayout(classPanel);
        classPanel.setLayout(classPanelLayout);
        setClassPanelHorizontalLayout(classPanelLayout);
        setClassPanelVerticalLayout(classPanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the classPanel using the provided
    //          GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setClassPanelHorizontalLayout(GroupLayout classPanelLayout) {
        classPanelLayout.setHorizontalGroup(
                classPanelLayout.createParallelGroup()
                        .addGroup(classPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(knightButton, -2, 228, -2)
                                .addGap(10)
                                .addComponent(barbarianButton, -2, 228, -2)
                                .addGap(10)
                                .addComponent(rangerButton, -2, 228, -2)
                                .addContainerGap())
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the classPanel using the provided GroupLayout.
    //          This involves setting vertical gaps and creating sequential or parallel groups.
    private void setClassPanelVerticalLayout(GroupLayout classPanelLayout) {
        classPanelLayout.setVerticalGroup(
                classPanelLayout.createParallelGroup()
                        .addGroup(classPanelLayout.createSequentialGroup()
                                .addGroup(classPanelLayout.createParallelGroup()
                                        .addComponent(rangerButton, -2, 93, -2)
                                        .addComponent(barbarianButton, -2, 93, -2)
                                        .addComponent(knightButton, -2, 93, -2))
                                .addGap(3))
        );
    }


    // MODIFIES: this
    // EFFECTS: Arranges the components within the confirmPanel, using a layout manager to control their positioning and
    //          sizing.
    private void addComponentToConfirmPanel() {
        GroupLayout confirmPanelLayout = new GroupLayout(confirmPanel);
        confirmPanel.setLayout(confirmPanelLayout);
        confirmPanelLayout.setHorizontalGroup(
                confirmPanelLayout.createParallelGroup()
                        .addGroup(confirmPanelLayout.createSequentialGroup()
                                .addComponent(backButton, -2, 226, -2)
                                .addGap(258)
                                .addComponent(createButton, -2, 226, -2))
        );
        confirmPanelLayout.setVerticalGroup(
                confirmPanelLayout.createParallelGroup()
                        .addComponent(backButton, -2, 44, -2)
                        .addComponent(createButton, -2, 44, -2)
        );
    }

    // MODIFIES: this
    // EFFECTS: Arranges the components within the newCharacterPanel, using a layout manager to control their
    // positioning and sizing.
    private void addComponentToNewCharacterPanel() {
        newCharacterPanel.setBackground(new Color(255, 255, 255));
        GroupLayout newCharacterPanelLayout = new GroupLayout(newCharacterPanel);
        newCharacterPanel.setLayout(newCharacterPanelLayout);
        setNewCharacterPanelHorizontalLayout(newCharacterPanelLayout);
        setNewCharacterPanelVerticalLayout(newCharacterPanelLayout);
    }

    // MODIFIES: this
    // EFFECTS: Defines the horizontal arrangement of the components within the newCharacterPanel using the provided
    // GroupLayout. This involves setting horizontal gaps and creating sequential or parallel groups.
    private void setNewCharacterPanelHorizontalLayout(GroupLayout newCharacterPanelLayout) {
        newCharacterPanelLayout.setHorizontalGroup(
                newCharacterPanelLayout.createParallelGroup()
                        .addComponent(namePanel, -2, 711, -2)
                        .addGroup(newCharacterPanelLayout.createSequentialGroup()
                                .addGroup(newCharacterPanelLayout.createParallelGroup()
                                        .addComponent(genderPanel, -2, 711, -2)
                                        .addComponent(classPanel, -2, 711, -2)
                                        .addComponent(confirmPanel, -2, 711, -2)
                                ))
                        .addComponent(titleLabel, -2, 721, -2)
        );
    }

    // MODIFIES: this
    // EFFECTS: Defines the vertical arrangement of the components within the newCharacterPanel using the provided
    // roupLayout. This involves setting vertical gaps and creating sequential or parallel groups.
    private void setNewCharacterPanelVerticalLayout(GroupLayout newCharacterPanelLayout) {
        newCharacterPanelLayout.setVerticalGroup(
                newCharacterPanelLayout.createParallelGroup()
                        .addGroup(newCharacterPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, -2, 88, -2)
                                .addGap(5)
                                .addComponent(namePanel, -2, 77, -2)
                                .addGap(5)
                                .addComponent(genderPanel, -2, 156, -2)
                                .addGap(5)
                                .addComponent(classPanel, -2, 96, -2)
                                .addGap(5)
                                .addComponent(confirmPanel, -2, 44, -2)
                                .addGap(157))
        );
    }

    // MODIFIES: this
    // EFFECTS: Adds the components to the JFrame, adjusting their layout properties (e.g., bounds) for proper display.
    private void addComponentsToFrame() {
        add(newCharacterPanel);
        newCharacterPanel.setBounds(40, 60, 720, 490);
        background.setIcon(new ImageIcon("data/pictures/characterbackground.png"));
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