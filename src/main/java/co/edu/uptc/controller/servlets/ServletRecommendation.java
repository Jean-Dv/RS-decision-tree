package co.edu.uptc.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uptc.controller.RatingController;
import co.edu.uptc.model.Movie;
import co.edu.uptc.model.Rating;
//import co.edu.uptc.controller.RatingController;
import co.edu.uptc.model.User;
//import co.edu.uptc.model.tree.DecisionTreeRecommender;
import co.edu.uptc.model.tree.DecisionTreeRecommender;

/**
 * ServletRecomendation
 */
@WebServlet("/recommendation")
public class ServletRecommendation extends HttpServlet {
    private User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * RatingController ratingController = new RatingController();
         * String attribute = "";
         * DecisionTreeRecommender decisionTreeRecommender = new
         * DecisionTreeRecommender(ratingController.getRatings(),
         * attribute);
         * 
         * Map<String, String> userAttributes = new HashMap<String, String>();
         * userAttributes.put(attribute, user.getNationality());
         * 
         */

        List<Movie> users = new ArrayList<>();
        User user = new User(2, "Phantom Thread (2017)", "Drama|Romance", "male", "colobia");
        Movie movie1 = new Movie(2, "Phantom Thread (2017)", new ArrayList<String>());
        Movie movie2 = new Movie(181413, "Too Funny to Fail: The Life and Death of The Dana Carvey Show (2017)",
                new ArrayList<>());
        Movie movie3 = new Movie(182727, "A Christmas Story Live! (2017)", new ArrayList<>());
        Movie movie4 = new Movie(183295, "Insidious: The Last Key (2018)", new ArrayList<>());
        Movie movie5 = new Movie(184987, "A Wrinkle in Time (2018)", new ArrayList<>());
        users.add(movie1);
        users.add(movie2);
        users.add(movie3);
        users.add(movie4);
        users.add(movie5);
        System.out.println(this.user.toString());
        HttpSession mSession = request.getSession();
        mSession.setAttribute("users", users);
        response.sendRedirect(request.getContextPath() + "/pages/showrecomendations.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public User getUser(User user) {
        return this.user;

    }

}