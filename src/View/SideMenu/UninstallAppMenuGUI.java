package View.SideMenu;

import javax.swing.*;
import java.awt.*;
import Controller.Apps.Apps;
import Models.UserProfile;
import Models.ComputerApp;
import View.Menus.MainMenuGUI;

public class UninstallAppMenuGUI {
    private static final int ITEMS_PER_PAGE = 5;
    private int currentPage = 0;
    private final java.util.List<ComputerApp> installedApps;
    private final DefaultListModel<String> listModel;
    private final JButton prevButton;
    private final JButton nextButton;

    public UninstallAppMenuGUI(UserProfile userProfile, String username) {
        JFrame frame = new JFrame("Uninstall App Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Uninstall App Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        installedApps = Apps.getInstalledApps();

        listModel = new DefaultListModel<>();
        populatePage();

        JList<String> appList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(appList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        prevButton = new JButton("Previous");
        prevButton.addActionListener(e -> {
            currentPage--;
            populatePage();
            updateButtonStates();
        });
        buttonPanel.add(prevButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            currentPage++;
            populatePage();
            updateButtonStates();
        });
        buttonPanel.add(nextButton);

        updateButtonStates();

        JButton uninstallButton = new JButton("Uninstall");
        uninstallButton.addActionListener(e -> {
            int selectedIndex = appList.getSelectedIndex();
            if (selectedIndex != -1) {
                int appIndex = currentPage * ITEMS_PER_PAGE + selectedIndex;
                ComputerApp selectedApp = installedApps.get(appIndex);
                Apps.uninstallApp(selectedApp);
                JOptionPane.showMessageDialog(frame, selectedApp.getAppName() + " has been uninstalled.");

                installedApps.remove(appIndex);
                populatePage();
                updateButtonStates();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an app to uninstall.");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuGUI(userProfile, username);
        });

        buttonPanel.add(uninstallButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void populatePage() {
        listModel.clear();
        int start = currentPage * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, installedApps.size());

        for (int i = start; i < end; i++) {
            ComputerApp app = installedApps.get(i);
            listModel.addElement(app.getAppName() + " - Size: " + app.getAppSize() + "MB");
        }
    }

    private void updateButtonStates() {
        prevButton.setEnabled(currentPage > 0);
        nextButton.setEnabled((currentPage + 1) * ITEMS_PER_PAGE < installedApps.size());
    }
}
