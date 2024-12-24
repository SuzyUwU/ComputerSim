package Controller.Apps;

import Models.ComputerApp;
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

    @Deprecated
    public static List<String> getInstalledAppNames() {
        List<String> installedAppNames = new ArrayList<>();
        for (ComputerApp app : appList) {
            if (app.isInstalled()) {
                installedAppNames.add(app.getAppName());
            }
        }
        return installedAppNames;
    }

    @Deprecated
    public static void installAppByIndex(int appIndex, List<ComputerApp> installableApps) {
        if (appIndex < 1 || appIndex > installableApps.size()) {
            System.out.println("Invalid selection. Please try again.");
            return;
        }

        ComputerApp appToInstall = installableApps.get(appIndex - 1);
        if (!appToInstall.isInstalled()) {
            appToInstall.installApp();
        } else {
            System.out.println(appToInstall.getAppName() + " is already installed.");
        }
    }

    @Deprecated
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
            app.installApp();
        } else {
            System.out.println("App is already installed.");
        }
    }

    public static void uninstallApp(ComputerApp app) {
        if (app != null && app.isInstalled()) {
            app.uninstallApp();
        } else {
            System.out.println("App is not installed or invalid.");
        }
    }


}

