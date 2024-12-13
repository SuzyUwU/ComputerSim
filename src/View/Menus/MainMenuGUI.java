package View.Menus;

import javax.swing.*;
import java.awt.*;
import Controler.Apps.Apps;
import Controler.Data.DataHandler;
import Variables.UserProfile;
import View.SideMenu.DisplayInstalledAppsGUI;
import View.SideMenu.InstallAppMenuGUI;
import View.SideMenu.UninstallAppMenuGUI;

public class MainMenuGUI {
    private final UserProfile userProfile;
    private static String currentUsername;

    public MainMenuGUI(UserProfile userProfile, String currentUsername) {
        this.userProfile = userProfile;
        MainMenuGUI.currentUsername = currentUsername;
        createAndShowGUI();
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }


    public void createAndShowGUI() {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        frame.add(panel);

        JLabel title = new JLabel("Main Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title);

        JButton displayAppsButton = new JButton("Display Apps");
        JButton installAppButton = new JButton("Install App");
        JButton uninstallAppButton = new JButton("Uninstall App");
        JButton logoutButton = new JButton("Save and Log Out");

        panel.add(displayAppsButton);
        panel.add(installAppButton);
        panel.add(uninstallAppButton);
        panel.add(logoutButton);

        // Action for Display Apps button
        displayAppsButton.addActionListener(e -> {
            frame.dispose(); // Close the main menu
            new DisplayInstalledAppsGUI(userProfile, currentUsername);
        });

        // Action for Install App button
        installAppButton.addActionListener(e -> {
            frame.dispose(); // Close the main menu
            new InstallAppMenuGUI(userProfile, currentUsername);
        });

        // Action for Uninstall App button
        uninstallAppButton.addActionListener(e -> {
            frame.dispose(); // Close the main menu
            new UninstallAppMenuGUI(userProfile, currentUsername);
        });

        // Action for Logout button
        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Saving data...");
            DataHandler.saveApps(Apps.appList);
            DataHandler.saveData(userProfile);
            frame.dispose();
            new LoginMenuGUI(userProfile);
        });

        frame.setVisible(true);
    }
}
