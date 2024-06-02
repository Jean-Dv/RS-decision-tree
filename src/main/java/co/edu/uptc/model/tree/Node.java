package co.edu.uptc.model.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.uptc.model.Recommendation;

public class Node {
    String attribute;
    Map<String, Node> children;
    List<Recommendation> recommendations;

    public Node() {
        this.children = new HashMap<String, Node>();
        this.recommendations = new ArrayList<Recommendation>();
    }
}
