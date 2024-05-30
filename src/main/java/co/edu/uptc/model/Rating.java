package co.edu.uptc.model;

public class Rating {

    private int userId;
    private int movieId;
    private double rating;

    public Rating() {
    }

    public Rating(int userId, int itemId, double rating) {
        this.userId = userId;
        this.movieId = itemId;
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int itemId) {
        this.movieId = itemId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating [userId=" + userId + ", movieId=" + movieId + ", rating=" + rating + "]";
    }

}