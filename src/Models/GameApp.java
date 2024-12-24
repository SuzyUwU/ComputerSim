package Models;

import java.io.Serializable;

public class GameApp extends ComputerApp implements Serializable {
    private final String genre;

    public GameApp(String appName, int appSize, boolean isInstalled, boolean isFree, String genre) {
        super(appName, appSize, isInstalled, isFree, "Game");  // Pass "Game" as appType
        this.genre = genre;
    }

    @Override
    public void displayAppInfo() {
        super.displayAppInfo();
        System.out.println("Game Genre: " + genre);
    }
}
