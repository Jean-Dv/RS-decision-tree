package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Rating;
import co.edu.uptc.model.User;
import co.edu.uptc.util.FilePersistence;

public class UserController {
    private static UserController _instance;
    private FilePersistence<User> filePersistence;
    private ArrayList<User> users;

    private UserController() {
        this.users = new ArrayList<User>();
        filePersistence = new FilePersistence<User>();
    }

    public static UserController getInstance() {
        if (_instance == null) {
            _instance = new UserController();
            _instance.readUserFile("users", true);
        }
        return _instance;
    }

    public boolean addUser(User user, String fileName) {

        String[] list = new String[] { Integer.toString(user.getUserId()), user.getName(), user.getLastName(),
                user.getGender(),
                user.getNationality(), user.getGenderMovie() };

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

    public void readUserFile(String fileName, boolean force) {
        if (force) {
            this.users.clear();
        }
        if (this.users.size() > 0) {
            return;
        }
        List<String[]> lines = filePersistence.readFile(fileName);
        if (lines == null) {
            return;
        }

        for (String[] strings : lines) {
            User user = new User(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3],
                    strings[4], strings[5]);
            this.users.add(user);

        }

    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public User getUserById(int userId) {
        int left = 0;
        int right = users.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            User user = users.get(mid);

            if (user.getUserId() == userId) {
                return user;
            } else if (user.getUserId() < userId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // User not found
    }

}
