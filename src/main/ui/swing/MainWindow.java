package ui.swing;

import ui.swing.simulator.CharacterBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

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

    public MainWindow(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
        init();
    }

    private void init() {
        initComponents();
        setWindowProperties();
        configureButtons();
        configureButtonPanel();
        addComponentsToButtonPanelLayout();
        addComponentsToFrame();
        centreOnScreen();

        pack();
    }

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

    private void setWindowProperties() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 617));
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    private void configureButtons() {
        if (characterBuilder.getNumCharacters() == 0) {
            configureButton(newBuilder, "NEW BUILDER");
        } else {
            configureButton(newBuilder, "RESUME BUILDER");
        }
        configureButton(loadBuilder, "LOAD BUILDER");
        configureButton(saveBuilder, "SAVE BUILDER");
        configureButton(quitBuilder, "QUIT BUILDER");

        addListenerForNewGame();
        addListenerForSaveGame();
        addListenerForLoadGame();
        addListenerForQuitGame();
    }

    private void configureButton(JButton button, String text) {
        button.setFont(new Font("Hoefler Text", Font.BOLD, 24));
        button.setForeground(new Color(0, 102, 102));
        button.setText(text);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    private void addListenerForNewGame() {
        newBuilder.addActionListener(e -> {
            new CharacterLogWindow(characterBuilder);
            dispose();
        });
    }

    private void addListenerForLoadGame() {
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

    private void addListenerForSaveGame() {
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

    private void addListenerForQuitGame() {
        quitBuilder.addActionListener(e -> {
            showMessageDialog(this, "Thanks for playing!");
            dispose();
        });
    }

    private void configureButtonPanel() {
        buttonPanel.setOpaque(false);
    }

    private void addComponentsToButtonPanelLayout() {
        buttonPanel.setLayout(new GroupLayout(buttonPanel));
        GroupLayout buttonPanelLayout = (GroupLayout) buttonPanel.getLayout();

        setButtonPanelHorizontalLayout(buttonPanelLayout);
        setButtonPanelVerticalLayout(buttonPanelLayout);
    }

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

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

}
