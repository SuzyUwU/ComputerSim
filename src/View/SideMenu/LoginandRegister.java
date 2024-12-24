package View.SideMenu;

import Controller.Apps.AppFactory;
import View.Menus.MainMenuGUI;


import javax.swing.*;
import java.awt.*;

import static View.Menus.LoginMenuGUI.userProfile;

public class LoginandRegister {
    public static void showLoginDialog(JFrame frame) {
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

    public static void showRegisterDialog(JFrame frame) {
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
}
