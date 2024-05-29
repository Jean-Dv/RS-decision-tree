package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.Ratings;
import co.edu.uptc.model.User;
import co.edu.uptc.util.FilePersistence;

public class UserController {
    private FilePersistence<User> filePersistence;

    public UserController() {
        this.filePersistence = new FilePersistence<>();
    }

    public boolean addUser(User users, String fileName) {

        String[] list = new String[] { Integer.toString(users.getUserId()), users.getName(), users.getLastName(),
                users.getNationality() };

        if (filePersistence.saveUsersToCSV(list, fileName)) {
            return true;

        }
        return false;
    }

    public boolean addRanting(Ratings ratings, String fileName) {

        String[] list = new String[] { Integer.toString(ratings.getUserId()), Integer.toString(ratings.getItemId()),
                Double.toString(ratings.getRating()) };

        if (filePersistence.saveUsersToCSV(list, fileName)) {
            return true;

        }
        return false;
    }
}
