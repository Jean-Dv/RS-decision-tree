package co.edu.uptc.view;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.Rating;
import co.edu.uptc.model.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User(12, "juan", "fernadez", "masculino", "colombiano");

        Rating rating = new Rating(12, 45, 1);
        userController.addUser(user, "MOCK_DATA");
        userController.addRating(rating, "MOCK_DATA");
    }
}
