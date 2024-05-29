package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.User;
import co.edu.uptc.util.FilePersistence;

public class UserController {

    private FilePersistence<User> filePersistence;
    private ArrayList<User> users;

    public UserController() {
        this.users = new ArrayList<User>();
    }

    public boolean add(ArrayList<User> users, String fileName) {
        filePersistence = new FilePersistence<>();

        return filePersistence.saveUsersToCSV(users, fileName);
    }

    public void readUserFile(String fileName) {
        filePersistence = new FilePersistence<User>();
        String[] lines = filePersistence.readFile(fileName);

        if (lines != null) {
            for (String line : lines) {
                String[] userData = line.split(",");
                if (userData.length == 4) {

                    User user = new User(userData[0], userData[1], userData[2], userData[3]);
                    this.users.add(user);

                }

            }
        }
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

}
