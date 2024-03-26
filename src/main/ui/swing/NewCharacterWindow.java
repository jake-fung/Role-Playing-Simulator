package ui.swing;

import model.Classes;
import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

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
    private JLabel textLabel;
    private JLabel nameLabel;
    private Boolean isMale;
    private Classes classes;
    private String characterName;

    public NewCharacterWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    private void init() {
        initComponents();
        setWindowProperties();
        configureNewCharacterPanel();
        configureTitle();
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

    private void initComponents() {
        newCharacterPanel = new JPanel();
        textLabel = new JLabel();
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

    private void setWindowProperties() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    private void configureNewCharacterPanel() {
        newCharacterPanel.setBackground(new Color(255, 255, 255));
    }

    private void configureTitle() {
        textLabel.setBackground(new Color(0, 204, 204));
        textLabel.setFont(new Font("Hoefler Text", Font.PLAIN, 48));
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textLabel.setText("CREATE YOUR CHARACTER");
        textLabel.setOpaque(true);
    }

    private void configureComponentsInNamePanel() {
        nameLabel.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        nameLabel.setText("Your name:");

        nameTextField.setFont(new Font("Hoefler Text", Font.PLAIN, 24));
    }

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

    private void addComponentToNamePanel() {
        GroupLayout namePanelLayout = new GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        setNamePanelHorizontalLayout(namePanelLayout);
        setNamePanelVerticalLayout(namePanelLayout);
    }

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

    private void addComponentToClassPanel() {
        GroupLayout classPanelLayout = new GroupLayout(classPanel);
        classPanel.setLayout(classPanelLayout);
        setClassPanelHorizontalLayout(classPanelLayout);
        setClassPanelVerticalLayout(classPanelLayout);
    }

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

    private void addComponentToNewCharacterPanel() {
        GroupLayout newCharacterPanelLayout = new GroupLayout(newCharacterPanel);
        newCharacterPanel.setLayout(newCharacterPanelLayout);
        setNewCharacterPanelHorizontalLayout(newCharacterPanelLayout);
        setNewCharacterPanelVerticalLayout(newCharacterPanelLayout);
    }

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
                        .addComponent(textLabel, -2, 721, -2)
        );
    }

    private void setNewCharacterPanelVerticalLayout(GroupLayout newCharacterPanelLayout) {
        newCharacterPanelLayout.setVerticalGroup(
                newCharacterPanelLayout.createParallelGroup()
                        .addGroup(newCharacterPanelLayout.createSequentialGroup()
                                .addComponent(textLabel, -2, 88, -2)
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

    private void addComponentsToFrame() {
        add(newCharacterPanel);
        newCharacterPanel.setBounds(40, 60, 720, 490);
        background.setIcon(new ImageIcon("data/pictures/characterbackground.png"));
        add(background);
        background.setBounds(0, 0, 800, 617);
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

}