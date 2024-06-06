package co.edu.uptc.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Rating;
import co.edu.uptc.util.FilePersistence;

public class RatingController {

    private static RatingController _instance;
    private FilePersistence<Rating> filePersistence;
    private ArrayList<Rating> ratings;

    private RatingController() {
        this.ratings = new ArrayList<Rating>();
        filePersistence = new FilePersistence<Rating>();
    }

    public static RatingController getInstance() {
        if (_instance == null) {
            _instance = new RatingController();
            _instance.readRatingFile("ratings", true);
        }
        return _instance;
    }

    public void readRatingFile(String fileName, boolean force) {
        if (force) {
            this.ratings.clear();
        }
        if (this.ratings.size() > 0) {
            return;
        }
        List<String[]> lines = filePersistence.readFile(fileName);

        for (String[] strings : lines) {
            Rating ratings = new Rating(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]),
                    Double.parseDouble(strings[2]));
            this.ratings.add(ratings);

        }
    }

    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

}
