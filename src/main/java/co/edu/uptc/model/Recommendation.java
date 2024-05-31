package co.edu.uptc.model;

/**
 * This class represents a recommendation for a specific item.
 */
public class Recommendation {
    private int itemId;
    private double score;

    public Recommendation(int itemId, double score) {
        this.itemId = itemId;
        this.score = score;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
