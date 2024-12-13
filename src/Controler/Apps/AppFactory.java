package Controler.Apps;

import Controler.Data.DataHandler;
import Variables.ComputerApp;
import Variables.GameApp;
import Variables.SocialApp;
import Variables.UtilityApp;

import java.util.List;

public class AppFactory {
    public static void createApps() {
        Apps apps = new Apps();

        apps.addApp(new UtilityApp("Photo", 200, false, true, "Photo viewing and editing"));
        apps.addApp(new UtilityApp("Settings", 50, true, true, "System settings management"));
        apps.addApp(new UtilityApp("Calendar", 100, true, true, "Schedule and reminders"));
        apps.addApp(new UtilityApp("Web Browser", 300, true, true, "Browse the internet"));

        apps.addApp(new UtilityApp("Photo Editor", 250, true, true, "Utility"));
        apps.addApp(new GameApp("Premium Game", 1024, false, false, "Game"));
        apps.addApp(new UtilityApp("Music Player", 150, false, true, "Utility"));
        apps.addApp(new UtilityApp("Video Editor", 500, false, false, "Utility"));

        apps.addApp(new UtilityApp("File Compressor", 150, false, true, "Compresses files to save space"));
        apps.addApp(new GameApp("Epic Adventure", 1024, false, false, "Action"));
        apps.addApp(new SocialApp("Chat Buddy", 200, false, true, 5000));
        apps.addApp(new UtilityApp("Backup Tool", 300, true, false, "Automatic backups"));

        apps.addApp(new SocialApp("Social Messenger", 200, false, true, 500));
        apps.addApp(new GameApp("Strategy Game", 1500, false, false, "Strategy"));
        apps.addApp(new UtilityApp("Fitness Tracker", 100, false, true, "Track your fitness"));
        apps.addApp(new UtilityApp("Photo Filter App", 300, false, true, "Add filters to your photos"));
        apps.addApp(new GameApp("Shooter Game", 1200, false, false, "Shooting"));
        apps.addApp(new UtilityApp("Weather Forecast", 50, false, true, "Check the weather"));
        apps.addApp(new UtilityApp("News Reader", 80, false, true, "Read the news"));
        apps.addApp(new SocialApp("Social Network", 500, false, true, 1000));
        apps.addApp(new GameApp("Puzzle Game", 300, false, true, "Puzzle"));
        apps.addApp(new UtilityApp("Streaming App", 400, false, false, "Stream videos"));
        apps.addApp(new GameApp("Adventure Game", 2000, false, false, "Adventure"));
        apps.addApp(new SocialApp("Chat App", 150, false, true, 200));
        apps.addApp(new UtilityApp("Online Store", 250, false, true, "Shop online"));
        apps.addApp(new UtilityApp("Banking App", 100, false, false, "Manage your finances"));
        apps.addApp(new UtilityApp("Video Streaming", 800, false, false, "Watch videos"));
        apps.addApp(new GameApp("Racing Game", 1800, false, false, "Racing"));
        apps.addApp(new SocialApp("Dating App", 90, false, true, 300));
        apps.addApp(new UtilityApp("Music Streaming", 500, false, true, "Listen to music"));
        apps.addApp(new UtilityApp("Language Learning", 200, false, false, "Learn new languages"));
        apps.addApp(new UtilityApp("Virtual Meeting App", 400, false, true, "Join meetings online"));
        apps.addApp(new GameApp("Platformer Game", 1400, false, false, "Platformer"));
        apps.addApp(new GameApp("Trivia Game", 250, false, true, "Trivia"));
        apps.addApp(new UtilityApp("Cooking App", 150, false, true, "Find cooking recipes"));
        apps.addApp(new UtilityApp("Fitness App", 200, false, false, "Track workouts"));
        apps.addApp(new GameApp("Virtual Pet Game", 500, false, true, "Take care of a virtual pet"));
    }
    public static void loadApps() {
        List<ComputerApp> loadedApps = DataHandler.loadApps();
        if (!loadedApps.isEmpty()) {
            Apps.appList.clear();
            Apps.appList.addAll(loadedApps);
            System.out.println("Apps loaded successfully.");
        } else {
            createApps();
        }
    }
}
