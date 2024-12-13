package View.SideMenu;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Controler.Apps.Apps;
import Variables.ComputerApp;
import Variables.UserProfile;
import View.Menus.MainMenuGUI;

public class DisplayInstalledAppsGUI {
    private static final int ITEMS_PER_PAGE = 5; // Number of items per page
    private int currentPage = 0; // Current page index
    private List<ComputerApp> installedApps;
    private final DefaultListModel<String> listModel;
    private final JButton prevButton;
    private final JButton nextButton;
    private final JComboBox<String> categoryComboBox;

    public DisplayInstalledAppsGUI(UserProfile userProfile, String username) {
        JFrame frame = new JFrame("Display Installed Apps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Installed Apps", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        String[] categories = {"All Installed Apps", "Utility Apps", "Game Apps", "Social Apps"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.addActionListener(e -> {
            currentPage = 0;
            updateInstalledApps();
            populatePage();
            updateButtonStates();
        });
        panel.add(categoryComboBox, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        installedApps = Apps.getInstalledApps();
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

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuGUI(userProfile, username);
        });

        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        updateButtonStates();
    }

    private void updateInstalledApps() {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();

        if (selectedCategory == null || selectedCategory.equals("All Installed Apps")) {
            installedApps = Apps.getInstalledApps();
        } else {
            installedApps = Apps.getInstalledAppsByCategory(selectedCategory.replace(" Apps", ""));
        }

        if (installedApps.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No apps found in this category.");
        }
    }

    private void populatePage() {
        listModel.clear();
        int start = currentPage * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, installedApps.size());

        for (int i = start; i < end; i++) {
            ComputerApp app = installedApps.get(i);
            listModel.addElement(app.getAppName() + " - Size: " + app.getAppSize() + " MB");
        }
    }

    private void updateButtonStates() {
        prevButton.setEnabled(currentPage > 0);
        nextButton.setEnabled((currentPage + 1) * ITEMS_PER_PAGE < installedApps.size());
    }
}
