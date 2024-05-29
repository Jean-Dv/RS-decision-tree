package co.edu.uptc.model.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.edu.uptc.model.Rating;
import co.edu.uptc.model.Recommendation;

public class DecisionTreeRecommender {
    private Node root;
    private static final int THREESHOLD = 5;

    public DecisionTreeRecommender(List<Rating> ratings) {
        this.root = this.buildTree(ratings);
    }

    private Node buildTree(List<Rating> ratings) {
        Node node = new Node();
        if (ratings.size() < THREESHOLD) {
            node.recommendations = this.computeRecommendations(ratings);
            return node;
        }

        String bestAttribute = this.findBestSplitAttribute(ratings);
        if (bestAttribute == null) {
            node.recommendations = this.computeRecommendations(ratings);
            return node;
        }

        Map<String, List<Rating>> splitRatings = this.splitByAttribute(ratings, bestAttribute);
        node.attribute = bestAttribute;

        for (Map.Entry<String, List<Rating>> entry : splitRatings.entrySet()) {
            node.children.put(entry.getKey(), buildTree(entry.getValue()));
        }
        return node;
    }

    private String findBestSplitAttribute(List<Rating> ratings) {
        return "genre";
    }

    private Map<String, List<Rating>> splitByAttribute(List<Rating> ratings, String attribute) {
        Map<String, List<Rating>> splitRatings = new HashMap<>();
        for (Rating rating : ratings) {
            String attributeValue = rating.getGenre();
            splitRatings.putIfAbsent(attributeValue, new ArrayList<Rating>());
            splitRatings.get(attributeValue).add(rating);
        }
        return splitRatings;
    }

    private List<Recommendation> computeRecommendations(List<Rating> ratings) {
        Map<Integer, Double> scores = new HashMap<Integer, Double>();
        for (Rating rating : ratings) {
            scores.put(rating.getItemId(), scores.getOrDefault(rating.getItemId(), 0.0) + rating.getRating());
        }
        return scores.entrySet().stream()
                .map(e -> new Recommendation(e.getKey(), e.getValue() / ratings.size()))
                .sorted((Recommendation a, Recommendation b) -> Double.compare(b.getScore(), a.getScore()))
                .collect(Collectors.toList());
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
