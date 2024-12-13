package Controler.Data;

import Variables.ComputerApp;
import Variables.UserProfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {

    private static final String SAVE_FILE = "userdata.ser";

    public static void saveData(UserProfile userProfile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(userProfile);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static UserProfile loadData() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return new UserProfile();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            return (UserProfile) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new UserProfile();
        }
    }

    public static void saveApps(List<ComputerApp> appList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("apps.ser"))) {
            oos.writeObject(appList);
            System.out.println("Apps saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving apps: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<ComputerApp> loadApps() {
        File file = new File("apps.ser");
        if (!file.exists()) {
            System.out.println("No saved apps found. Starting fresh.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<ComputerApp>) obj;
            } else {
                System.out.println("Invalid data format. Starting fresh.");
                return new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading apps: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
