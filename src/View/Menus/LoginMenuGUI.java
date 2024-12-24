package View.Menus;

import javax.swing.*;
import java.awt.*;

import Models.UserProfile;

import static View.SideMenu.LoginandRegister.showLoginDialog;
import static View.SideMenu.LoginandRegister.showRegisterDialog;

public class LoginMenuGUI {
    public static UserProfile userProfile = null;

    public LoginMenuGUI(UserProfile userProfile) {
        LoginMenuGUI.userProfile = userProfile;
    }

    public static boolean ShowGUI() {
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

    public void out() {
    }
}
