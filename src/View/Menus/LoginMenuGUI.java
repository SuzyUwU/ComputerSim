package View.Menus;

import javax.swing.*;
import java.awt.*;

import Controler.Apps.AppFactory;
import Variables.UserProfile;

public class LoginMenuGUI {
    private static UserProfile userProfile = null;

    public LoginMenuGUI(UserProfile userProfile) {
        LoginMenuGUI.userProfile = userProfile;
    }

    public static boolean createAndShowGUI() {
        JFrame frame = new JFrame("Login Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        frame.add(panel);

        JLabel title = new JLabel("Login Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");

        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);

        loginButton.addActionListener(e -> showLoginDialog(frame));
        registerButton.addActionListener(e -> showRegisterDialog(frame));
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Exiting the app...");
            System.exit(0);
        });

        frame.setVisible(true);
        return false;
    }

    private static void showLoginDialog(JFrame frame) {
        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(frame, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (userProfile.validateCredentials(username, password)) {
                AppFactory.loadApps();
                JOptionPane.showMessageDialog(frame, "Login successful! Welcome, " + username);
                new MainMenuGUI(userProfile, username);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void showRegisterDialog(JFrame frame) {
        JPanel registerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        registerPanel.add(new JLabel("New Username:"));
        registerPanel.add(usernameField);
        registerPanel.add(new JLabel("New Password:"));
        registerPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(frame, registerPanel, "Register", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (userProfile.userExists(username)) {
                JOptionPane.showMessageDialog(frame, "Username already exists. Try a different one.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                userProfile.addUser(username, password);
                JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
            }
        }
    }

    public void out() {
    }
}
