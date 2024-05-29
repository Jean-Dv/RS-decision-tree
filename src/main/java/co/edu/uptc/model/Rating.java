package co.edu.uptc.model;

/**
 * This class represents a rating for a specific item.
 */
public class Rating {
    private int userId;
    private int itemId;
    private double rating;
    private String genre;

    public Rating(int userId, int itemId, double rating, String genre) {
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
        this.genre = genre;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
