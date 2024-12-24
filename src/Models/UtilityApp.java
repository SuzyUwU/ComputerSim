package Models;

import java.io.Serializable;

public class UtilityApp  extends ComputerApp implements Serializable {
    private final String utilityFeature;

    public UtilityApp(String appName, int appSize, boolean isInstalled, boolean isFree, String utilityFeature) {
        super(appName, appSize, isInstalled, isFree, "Utility");  // Pass "Utility" as appType
        this.utilityFeature = utilityFeature;
    }

    @Override
    public void displayAppInfo() {
        super.displayAppInfo();
        System.out.println("Utility Feature: " + utilityFeature);
    }
}
