import Models.UserProfile;
import Controller.Data.DataHandler;
import View.Menus.LoginMenuGUI;
import View.Menus.MainMenuGUI;


public class Main {
    public static void main(String[] args) {
        System.out.println("Name: Yudha Pratama Putra\nnim: 23051204108\nclass: TID23\n\ntopic: Computer Apps");

        UserProfile userProfile = DataHandler.loadData();
        LoginMenuGUI loginMenu = new LoginMenuGUI(userProfile);
        loginMenu.out();

        if (LoginMenuGUI.createAndShowGUI()) {
            String currentUsername = MainMenuGUI.getCurrentUsername();
            MainMenuGUI mainMenu = new MainMenuGUI(userProfile, currentUsername);
            mainMenu.createAndShowGUI();
        } else {
            System.out.println("Exiting the application...");
        }
    }
}
