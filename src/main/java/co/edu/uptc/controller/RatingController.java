package co.edu.uptc.controller;

import java.util.ArrayList;

import co.edu.uptc.model.Rating;
import co.edu.uptc.util.FilePersistence;

public class RatingController {

    private FilePersistence<Rating> filePersistence;
    private ArrayList<Rating> ratings;

    public RatingController() {
        this.ratings = new ArrayList<Rating>();
        filePersistence = new FilePersistence<Rating>();
    }

    public void readRatingFile(String fileName) {
        String[] lines = filePersistence.readFile(fileName);
        if (lines != null) {
            for (String line : lines) {
                String[] userData = line.split(",");
                if (userData.length == 3) {

                    Rating ratings = new Rating(Integer.parseInt(userData[0]), Integer.parseInt(userData[1]),
                            Double.parseDouble(userData[2]));
                    this.ratings.add(ratings);
                }
            }
        }

    }

    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

}
