package Models;

import java.io.Serializable;

public class SocialApp extends ComputerApp implements Serializable {
    private final int userCount;

    public SocialApp(String appName, int appSize, boolean isInstalled, boolean isFree, int userCount) {
        super(appName, appSize, isInstalled, isFree, "Social");  // Pass "Social" as appType
        this.userCount = userCount;
    }

    @Override
    public void displayAppInfo() {
        super.displayAppInfo();
        System.out.println("User Count: " + userCount);
    }
}
