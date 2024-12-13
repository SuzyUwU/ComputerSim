package Controler.Apps;

import Variables.ComputerApp;
import java.util.ArrayList;
import java.util.List;

public class Apps {
    public static final List<ComputerApp> appList = new ArrayList<>();

    public Apps() {

    }

    public static List<ComputerApp> getInstalledAppsByCategory(String category) {
        List<ComputerApp> installedApps = new ArrayList<>();
        for (ComputerApp app : appList) {
            if (app.isInstalled() && app.getAppType().equalsIgnoreCase(category)) {
                installedApps.add(app);
            }
        }
        return installedApps;
    }

    public void addApp(ComputerApp app) {
        appList.add(app);
    }

    public static List<ComputerApp> getInstalledApps() {
        List<ComputerApp> installedApps = new ArrayList<>();
        for (ComputerApp app : appList) {
            if (app.isInstalled()) {
                installedApps.add(app);
            }
        }
        return installedApps;
    }

    public static List<String> getInstalledAppNames() {
        List<String> installedAppNames = new ArrayList<>();
        for (ComputerApp app : appList) {
            if (app.isInstalled()) {
                installedAppNames.add(app.getAppName());
            }
        }
        return installedAppNames;
    }

    public static void installAppByIndex(int appIndex, List<ComputerApp> installableApps) {
        // Adjust index for zero-based array access
        if (appIndex < 1 || appIndex > installableApps.size()) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        ComputerApp appToInstall = installableApps.get(appIndex - 1); // Convert to zero-based index
        if (!appToInstall.isInstalled()) {
            appToInstall.installApp(); // Install the app
        } else {
            System.out.println(appToInstall.getAppName() + " is already installed.");
        }
    }

    public static void uninstallAppByIndex(int index) {
        if (index < 1 || index > appList.size()) {
            System.out.println("Invalid app number.");
            return;
        }
        ComputerApp app = appList.get(index - 1);
        if (app.isInstalled()) {
            app.uninstallApp();
        } else {
            System.out.println("App is not installed.");
        }
    }

    public static void installApp(ComputerApp app) {
        if (app != null && !app.isInstalled()) {
            app.installApp(); // Assuming your app object has this method
        } else {
            System.out.println("App is already installed.");
        }
    }

    public static void uninstallApp(ComputerApp app) {
        if (app != null && app.isInstalled()) {
            app.uninstallApp(); // Assuming the app object has this method
        } else {
            System.out.println("App is not installed or invalid.");
        }
    }


}

