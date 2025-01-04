import Models.UserProfile;
import Controller.Data.DataHandler;
import View.Menus.LoginMenuGUI;
import View.Menus.MainMenuGUI;


public class Main {
    public static void main(String[] args) {
        System.out.println("topic: Computer Simulation \n code made by : Yudha Pratama Putra \n\n credits:\n Gitarivo Frizqi Putranda Cavalera (23051204106) \n Yudha Pratama Putra (23051204108) \n Lubna Sajidah (23051204111) \n Nazwa Dewanti Asyifa (23051204119) \n Muhammad Husaini Rahmatulloh (23051204125) \n\n code made by love from :\n Group 5 PBO");

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
