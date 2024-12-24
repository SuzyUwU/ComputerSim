package Models;

import java.io.Serializable;
import java.util.HashMap;

public class UserProfile implements Serializable {
    private final HashMap<String, String> userCredentials;

    public UserProfile() {
        userCredentials = new HashMap<>();
    }

    public boolean validateCredentials(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public boolean userExists(String username) {
        return userCredentials.containsKey(username);
    }

    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }
}
