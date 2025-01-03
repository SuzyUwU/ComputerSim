import Models.UserProfile;
import Controller.Data.DataHandler;
import View.Menus.LoginMenuGUI;
import View.Menus.MainMenuGUI;


public class Main {
    public static void main(String[] args) {
        System.out.println("topic: Computer Simulation \n\n credits Z:\n Gitarivo Frizqi Putranda Cavalera \n Yudha Pratama Putra \n Lubna Sajidah \n Nazwa Dewanti Asyifa \n Muhammad Husaini Rahmatulloh \n code made by love from :\n Group 5 PBO");

        UserProfile userProfile = DataHandler.loadData();
        LoginMenuGUI loginMenu = new LoginMenuGUI(userProfile);
        loginMenu.out();

        if (LoginMenuGUI.ShowGUI()) {
            String currentUsername = MainMenuGUI.getCurrentUsername();
            MainMenuGUI mainMenu = new MainMenuGUI(userProfile, currentUsername);
            mainMenu.createAndShowGUI();
        } else {
            System.out.println("Exiting the application...");
        }
    }
}
