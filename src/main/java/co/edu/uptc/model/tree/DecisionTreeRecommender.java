package co.edu.uptc.model.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.edu.uptc.controller.MovieController;
import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.Rating;
import co.edu.uptc.model.Recommendation;

public class DecisionTreeRecommender {
    private Node root;
    private String attribute;
    private MovieController movieController = new MovieController();
    private UserController userController = new UserController();
    private static final int THREESHOLD = 5;

    public DecisionTreeRecommender(List<Rating> ratings, String attribute) {
        userController.readUserFile("users");
        movieController.readMovieFile("movies");
        this.attribute = attribute;
        this.root = this.buildTree(ratings, true);
    }

    private Node buildTree(List<Rating> ratings, boolean isRoot) {
        Node node = new Node();
        if (ratings.size() < THREESHOLD) {
            node.recommendations = this.computeRecommendations(ratings);
            return node;
        }

        if (this.attribute == null || !isRoot) {
            node.recommendations = this.computeRecommendations(ratings);
            return node;
        }

        Map<String, List<Rating>> splitRatings = this.splitByAttribute(ratings, this.attribute);
        node.attribute = this.attribute;

        for (Map.Entry<String, List<Rating>> entry : splitRatings.entrySet()) {
            node.children.put(entry.getKey(), buildTree(entry.getValue(), false));
        }
        return node;
    }

    private Map<String, List<Rating>> splitByAttribute(List<Rating> ratings, String attribute) {

        Map<String, List<Rating>> splitRatings = new HashMap<>();
        for (Rating rating : ratings) {
            List<String> attributeValues = new ArrayList<>();
            if (this.attribute == "genre") {
                if (movieController.getMovieById(rating.getMovieId()) == null) {
                    attributeValues.add("Unknown");
                } else {
                    attributeValues = movieController.getMovieById(rating.getMovieId()).getGenres();
                }
            }
            if (this.attribute == "nationality") {
                attributeValues.add(userController.getUserById(rating.getUserId()).getNationality());
            }
            attributeValues.forEach(attributeValue -> {
                splitRatings.putIfAbsent(attributeValue, new ArrayList<Rating>());
                splitRatings.get(attributeValue).add(rating);
            });
        }
        return splitRatings;
    }

    private List<Recommendation> computeRecommendations(List<Rating> ratings) {
        Map<Integer, Double> scores = new HashMap<Integer, Double>();
        for (Rating rating : ratings) {
            scores.put(rating.getMovieId(), scores.getOrDefault(rating.getMovieId(), 0.0) + rating.getRating());
        }
        List<Recommendation> recommendations = new ArrayList<Recommendation>();
        recommendations = scores.entrySet().stream()
                .map(e -> new Recommendation(e.getKey(), e.getValue() / ratings.size()))
                .sorted((Recommendation a, Recommendation b) -> Double.compare(b.getScore(), a.getScore()))
                .collect(Collectors.toList());
        if (recommendations.size() > 10) {
            return recommendations.subList(0, 10);
        }
        return recommendations;
    }

    public List<Recommendation> getRecommendations(Map<String, String> userAttributes) {
        Node currentNode = root;
        while (currentNode.attribute != null) {
            String attributeValue = userAttributes.get(currentNode.attribute);
            currentNode = currentNode.children.getOrDefault(attributeValue, null);
            if (currentNode == null) {
                return new ArrayList<Recommendation>();
            }
        }
        return currentNode.recommendations;
    }
}
