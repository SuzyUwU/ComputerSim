package Models;

import java.io.Serializable;

public class ComputerApp implements Serializable {
        // Attributes
        private final String appName;
        private final int appSize; // size in MB
        private boolean isInstalled;
        private final boolean isFree;
        private final String appType;

        public ComputerApp(String appName, int appSize, boolean isInstalled, boolean isFree, String appType) {
            this.appName = appName;
            this.appSize = appSize;
            this.isInstalled = isInstalled;
            this.isFree = isFree;
            this.appType = appType;
        }

        public String getAppName() {
            return appName;
        }

        public int getAppSize() {
            return appSize;
        }

        public boolean isInstalled() {
            return isInstalled;
        }

        public String getAppType() {
            return appType;
        }

        public void installApp() {
            this.isInstalled = true;
            System.out.println(appName + " has been installed.");
        }

        public void uninstallApp() {
            this.isInstalled = false;
            System.out.println(appName + " has been uninstalled.");
        }

        // Display App Info
        public void displayAppInfo() {
            System.out.println("App Name: " + appName);
            System.out.println("App Size: " + appSize + " MB");
            System.out.println("Installed: " + (isInstalled ? "Yes" : "No"));
            System.out.println("App Type: " + appType);
            System.out.println("App Cost: " + (isFree ? "Free" : "Paid"));
        }

}
