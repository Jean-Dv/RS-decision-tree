package co.edu.uptc.view;

import java.util.ArrayList;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.Ratings;
import co.edu.uptc.model.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(12, "juan", "fernadez", "masculino", "colombiano");
        User user2 = new User(45, "david", "fernadez", "masculino", "colombiano");

        Ratings rating = new Ratings(12, 45, 1);
        userController.addUser(user, "MOCK_DATA");
        userController.addRanting(rating, "MOCK_DATA");
    }
}
