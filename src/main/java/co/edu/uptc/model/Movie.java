package co.edu.uptc.model;

import java.util.ArrayList;

public class Movie {
    private int movieId;
    private String title;
    private ArrayList<Genr> genres;

    public Movie() {
    }

    public Movie(int movieId, String title, ArrayList<Genr> genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Genr> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genr> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie movieId=" + movieId + ", title=" + title + ", genres=" + genres + "";
    }

}
