package co.edu.uptc.view;

import java.util.ArrayList;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.User;

public class App {
    public static void main(String[] args) {
        UserController userController = new UserController();
        User user = new User("juan", "fernadez", "masculino", "colombiano");
        User user2 = new User("david", "fernadez", "masculino", "colombiano");
        ArrayList<User> users = new ArrayList<>();

        users.add(user2);
        users.add(user);
        userController.add(users, "MOCK_DATA");
    }
}
