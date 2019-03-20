package class_7;

import java.awt.*;
import javax.swing.*;


public class NameDisplay {
    private JLabel welcomeMessage;
    private JTextField nameInputForm;
    private JFrame nameInputFrame;
    private JButton displayNameInputFormButton, nameInputFormButton;

    public static void main(String[] argv) throws Exception {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> new NameDisplay().start());
    }

    public void start() {
        nameInputForm = new JTextField("your name e.g. John Doe", 20);
        nameInputFormButton = new JButton("Enter your name");
        nameInputFormButton.addActionListener(e -> onNameInputFormSubmit());
        nameInputFrame = initInputNameFrame("Your name");

        displayNameInputFormButton = new JButton("Display name input form");
        displayNameInputFormButton.addActionListener(e -> nameInputFrame.setVisible(true));
        welcomeMessage = configureWelcomeMessage("I need your name!");
        initMainFrame("Welcome");
    }

    private void onNameInputFormSubmit() {
        welcomeMessage.setText(nameInputForm.getText());
        nameInputFrame.dispose();
    }

    private JLabel configureWelcomeMessage(String message) {
        Icon icon = new ImageIcon(ClassLoader.getSystemResource("images/policeman.jpg"));
        JLabel label = new JLabel(message, icon, JLabel.CENTER);
        label.setFont(new Font("serif", Font.PLAIN, 32));
        label.setForeground(Color.GRAY);
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        return label;
    }

    private JFrame initInputNameFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(nameInputForm);
        frame.getContentPane().add(nameInputFormButton);
        frame.setSize(400, 80);
        return frame;
    }

    private JFrame initMainFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(displayNameInputFormButton);
        frame.getContentPane().add(welcomeMessage);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        return frame;
    }
}
