package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.User;
import co.edu.uptc.util.FilePersistence;

public class UserController {

    private FilePersistence<User> filePersistence;

    public boolean add(ArrayList<User> users, String fileName) {
        filePersistence = new FilePersistence<>();

        return filePersistence.saveUsersToCSV(users, fileName);
    }
}
