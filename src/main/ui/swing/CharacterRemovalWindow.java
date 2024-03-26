package ui.swing;

import model.Character;
import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;

public class CharacterRemovalWindow extends JFrame {
    private final CharacterBuilder characterBuilder;
    private JButton backButton;
    private JLabel background;
    private JScrollPane characterScrollPane;
    private JList<String> characterList;
    private JPanel characterSelectionPanel;
    private JButton removeButton;
    private JPanel selectionPanel;
    private JLabel titleLabel;

    public CharacterRemovalWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

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

    private void initComponents() {
        characterSelectionPanel = new JPanel();
        titleLabel = new JLabel();
        characterScrollPane = new JScrollPane();
        selectionPanel = new JPanel();
        removeButton = new JButton();
        backButton = new JButton();
        background = new JLabel();
        setVisible(true);
    }

    private void setWindowProperties() {
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void configureTitleLabel() {
        titleLabel.setBackground(new Color(0, 204, 204));
        titleLabel.setFont(new Font("Hoefler Text", Font.BOLD, 48));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("SELECT YOUR CHARACTER");
        titleLabel.setOpaque(true);
    }

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

    private void configureButtons() {
        removeButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        removeButton.setText("REMOVE");
        addListenerForRemoveButton();

        backButton.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        backButton.setText("BACK");
        backButton.addActionListener(e -> {
            new CharacterLogWindow(characterBuilder);
            dispose();
        });
    }

    private void addListenerForRemoveButton() {
        removeButton.addActionListener(e -> {
            if (characterList.getSelectedIndex() != -1) {
                Character character = characterBuilder.getCharacter(characterList.getSelectedIndex());
                int result = showConfirmDialog(this, "Are you sure you want to remove "
                        + character.getName() + "?", "Confirm", YES_NO_OPTION);
                if (result == YES_OPTION) {
                    characterBuilder.removeResident(characterList.getSelectedIndex());
                    showMessageDialog(this, character.getName() + " has been suscessfully removed.");
                    configureCharacterMenu();
                }
            } else {
                showMessageDialog(this, "Select a character to remove.");
            }

        });
    }

    private void addComponentToSelectionPanel() {
        GroupLayout selectionPanelLayout = new GroupLayout(selectionPanel);
        selectionPanel.setLayout(selectionPanelLayout);
        selectionPanelLayout.setHorizontalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton, -2, 228, -2)
                                .addGap(245)
                                .addComponent(removeButton, -2, 223, -2)
                                .addContainerGap())
        );
        selectionPanelLayout.setVerticalGroup(
                selectionPanelLayout.createParallelGroup()
                        .addGroup(selectionPanelLayout.createParallelGroup()
                                        .addComponent(removeButton, -2, 52, -2)
                                        .addComponent(backButton, -2, 52, -2))
        );
    }

    private void addComponentToCharacterSelectionPanel() {
        characterSelectionPanel.setBackground(new Color(255, 255, 255));
        GroupLayout characterSelectionPanelLayout = new GroupLayout(characterSelectionPanel);
        characterSelectionPanel.setLayout(characterSelectionPanelLayout);
        setCharacterSelectionPanelHorizontalLayout(characterSelectionPanelLayout);
        setCharacterSelectionPanelVerticalLayout(characterSelectionPanelLayout);


    }

    private void setCharacterSelectionPanelHorizontalLayout(GroupLayout characterSelectionPanelLayout) {
        characterSelectionPanelLayout.setHorizontalGroup(
                characterSelectionPanelLayout.createParallelGroup()
                        .addComponent(titleLabel, -2, 720, -2)
                        .addGroup(characterSelectionPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(characterScrollPane)
                                .addContainerGap())
                        .addGroup(characterSelectionPanelLayout.createParallelGroup()
                                .addGroup(characterSelectionPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(selectionPanel)
                                        .addContainerGap()))
        );
    }

    private void setCharacterSelectionPanelVerticalLayout(GroupLayout characterSelectionPanelLayout) {
        characterSelectionPanelLayout.setVerticalGroup(
                characterSelectionPanelLayout.createParallelGroup()
                        .addGroup(characterSelectionPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel, -2, 88, -2)
                                .addGap(10)
                                .addComponent(characterScrollPane, -2, 331, -2)
                                .addGap(65))
                        .addGroup(characterSelectionPanelLayout.createParallelGroup()
                                .addGroup(characterSelectionPanelLayout.createSequentialGroup()
                                        .addGap(432)
                                        .addComponent(selectionPanel)))
        );
    }

    private void addComponentsToFrame() {
        add(characterSelectionPanel);
        characterSelectionPanel.setBounds(40, 60, 720, 490);

        background.setIcon(new ImageIcon("data/pictures/characterbackground.png"));
        background.setBounds(new Rectangle(0, 0, 800, 617));
        add(background);
        background.setBounds(0, 0, 800, 618);
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }
}
