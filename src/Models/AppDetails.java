package Models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AppDetails extends ComputerApp implements Serializable {

    private final String appLocation;
    private final LocalDateTime installedTime;

    public AppDetails(String appName, int appSize, boolean isInstalled, boolean isFree,
                       String appType, String appLocation, LocalDateTime installedTime) {
        super(appName, appSize, isInstalled, isFree, appType);
        this.appLocation = appLocation;
        this.installedTime = installedTime;
    }


    public String getAppLocation() {
        return appLocation;
    }

    public LocalDateTime getInstalledTime() {
        return installedTime;
    }


    @Override
    public void displayAppInfo() {
        super.displayAppInfo();
        System.out.println("App Location: " + appLocation);
        System.out.println("Installed Time: " + (installedTime != null ? installedTime : "Not Installed"));
    }
}
