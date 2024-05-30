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
                String[] ratingData = line.split(",");
                if (ratingData.length == 3) {

                    Rating ratings = new Rating(Integer.parseInt(ratingData[0]), Integer.parseInt(ratingData[1]),
                            Double.parseDouble(ratingData[2]));
                    this.ratings.add(ratings);
                }
            }
        }

    }

    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

}
