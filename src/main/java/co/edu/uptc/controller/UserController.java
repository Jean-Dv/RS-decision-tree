package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.Rating;
import co.edu.uptc.model.User;
import co.edu.uptc.util.FilePersistence;

public class UserController {
    private FilePersistence<User> filePersistence;
    private ArrayList<User> users;

    public UserController() {
        this.users = new ArrayList<User>();
        filePersistence = new FilePersistence<User>();
    }

    public boolean addUser(User user, String fileName) {

        String[] list = new String[] { Integer.toString(user.getUserId()), user.getName(), user.getLastName(),
                user.getNationality() };

        if (filePersistence.saveUsersToCSV(list, fileName)) {
            return true;

        }
        return false;
    }

    public boolean addRating(Rating ratings, String fileName) {

        String[] list = new String[] { Integer.toString(ratings.getUserId()), Integer.toString(ratings.getMovieId()),
                Double.toString(ratings.getRating()) };

        if (filePersistence.saveUsersToCSV(list, fileName)) {
            return true;

        }
        return false;
    }

    public void readUserFile(String fileName) {

        String[] lines = filePersistence.readFile(fileName);

        if (lines != null) {
            for (String line : lines) {
                String[] userData = line.split(",");
                if (userData.length == 5) {

                    User user = new User(Integer.parseInt(userData[0]), userData[1], userData[2], userData[3],
                            userData[4]);
                    this.users.add(user);

                }

            }
        }
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

}
