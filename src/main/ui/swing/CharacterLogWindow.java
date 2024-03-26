package ui.swing;

import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class CharacterLogWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JLabel background;
    private JButton backButton;
    private JButton newCharacter;
    private JButton removeCharacter;
    private JButton savedCharacter;
    private JPanel selectionPanel;
    private JLabel title;

    public CharacterLogWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    private void init() {
        initComponents();
        setWindowProperties();
        configureTitle();
        configureButtons();
        configureSelectionPanel();
        addComponentToSelectionPanel();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

    private void initComponents() {
        backButton = new JButton();
        selectionPanel = new JPanel();
        title = new JLabel();
        newCharacter = new JButton();
        savedCharacter = new JButton();
        removeCharacter = new JButton();
        background = new JLabel();
    }

    private void setWindowProperties() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    private void configureSelectionPanel() {
        selectionPanel.setBackground(new Color(255, 255, 255));
    }

    private void configureTitle() {
        title.setFont(new Font("Hoefler Text", Font.BOLD, 48));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setText("CHOOSE ONE");
        title.setBackground(new Color(0, 204, 204));
        title.setOpaque(true);
    }

    private void configureButtons() {
        newCharacter.setIcon(new ImageIcon("data/pictures/newcharacter.png"));
        addListenerForNewCharacter();
        savedCharacter.setIcon(new ImageIcon("data/pictures/savedcharacter.png"));
        addListenerForSavedCharacter();
        removeCharacter.setIcon(new ImageIcon("data/pictures/removecharacter.png"));
        addListenerForRemoveCharacter();
        configureBackButton();
    }

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

    private void addListenerForNewCharacter() {
        newCharacter.addActionListener(e -> {
            new NewCharacterWindow(characterBuilder);
            dispose();
        });
    }

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

    private void addComponentToSelectionPanel() {
        GroupLayout selectionPanelLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionPanelLayout);
        setSelectionPanelHorizontalLayout(selectionPanelLayout);
        setSelectionPanelVerticalLayout(selectionPanelLayout);
    }

    private void setSelectionPanelHorizontalLayout(GroupLayout selectionPanelLayout) {
        selectionPanelLayout.setHorizontalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addComponent(title, -2, 729, -2)
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

    private void setSelectionPanelVerticalLayout(GroupLayout selectionPanelLayout) {
        selectionPanelLayout.setVerticalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createSequentialGroup()
                                .addComponent(title, -2, 78, -2)
                                .addGap(25)
                                .addGroup(selectionPanelLayout.createParallelGroup()
                                        .addComponent(newCharacter)
                                        .addComponent(savedCharacter)
                                        .addComponent(removeCharacter)))
        );
    }

    private void addComponentsToFrame() {
        add(selectionPanel);
        selectionPanel.setBounds(34, 100, 729, 364);
        background.setIcon(new ImageIcon("data/pictures/Background.png"));
        add(background);
        background.setBounds(0, 0, 800, 617);
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

}
