package View.SideMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Controller.Apps.Apps;
import Models.UserProfile;
import Models.ComputerApp;
import View.Menus.MainMenuGUI;

public class InstallAppMenuGUI {
    private static final int ITEMS_PER_PAGE = 5;
    private int currentPage = 0;
    private final List<ComputerApp> installableApps;
    private DefaultListModel<String> listModel;
    private JButton prevButton;
    private JButton nextButton;

    public InstallAppMenuGUI(UserProfile userProfile, String username) {
        JFrame frame = new JFrame("Install App Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Install App Menu", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        installableApps = new ArrayList<>();
        for (ComputerApp app : Apps.appList) {
            if (!app.isInstalled()) {
                installableApps.add(app);
            }
        }

        if (installableApps.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All apps are installed.");
            frame.dispose();
            new MainMenuGUI(userProfile, username);
            return;
        }

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

        JButton installButton = new JButton("Install");
        installButton.addActionListener(e -> {
            int selectedIndex = appList.getSelectedIndex();
            if (selectedIndex != -1) {
                int appIndex = currentPage * ITEMS_PER_PAGE + selectedIndex;
                ComputerApp selectedApp = installableApps.get(appIndex);
                Apps.installApp(selectedApp);
                JOptionPane.showMessageDialog(frame, selectedApp.getAppName() + " has been installed.");

                installableApps.remove(appIndex);
                if (installableApps.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All apps are now installed.");
                    frame.dispose();
                    new MainMenuGUI(userProfile, username);
                    return;
                }
                populatePage();
                updateButtonStates();
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an app to install.");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenuGUI(userProfile, username);
        });

        buttonPanel.add(installButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void populatePage() {
        listModel.clear();
        int start = currentPage * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, installableApps.size());

        for (int i = start; i < end; i++) {
            ComputerApp app = installableApps.get(i);
            listModel.addElement(app.getAppName() + " - Size: " + app.getAppSize() + "MB");
        }
    }

    private void updateButtonStates() {
        prevButton.setEnabled(currentPage > 0);
        nextButton.setEnabled((currentPage + 1) * ITEMS_PER_PAGE < installableApps.size());
    }
}
