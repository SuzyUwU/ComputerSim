package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserProfile implements Serializable {
    private final HashMap<String, String> userCredentials;
    private final HashMap<String, List<String>> userInstalledApps;

    public UserProfile() {
        userCredentials = new HashMap<>();
        userInstalledApps = new HashMap<>();
    }

    public boolean validateCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public boolean userExists(String username) {
        return userCredentials.containsKey(username);
    }

    public void addUser(String username, String password) {
        userCredentials.put(username, password);
        userInstalledApps.put(username, new ArrayList<>());
    }

    public List<String> getInstalledApps(String username) {
        return userInstalledApps.getOrDefault(username, new ArrayList<>());
    }

    public void setInstalledApps(String username, List<String> apps) {
        userInstalledApps.put(username, apps);
    }

    public HashMap<String, String> getUserCredentials() {
        return userCredentials;
    }

    public HashMap<String, List<String>> getUserInstalledApps() {
        return userInstalledApps;
    }
}