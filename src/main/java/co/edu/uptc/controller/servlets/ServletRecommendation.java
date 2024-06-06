package co.edu.uptc.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uptc.controller.MovieController;
import co.edu.uptc.controller.RatingController;
import co.edu.uptc.model.Movie;
import co.edu.uptc.model.Rating;
import co.edu.uptc.model.Recommendation;
//import co.edu.uptc.controller.RatingController;
import co.edu.uptc.model.User;
//import co.edu.uptc.model.tree.DecisionTreeRecommender;
import co.edu.uptc.model.tree.DecisionTreeRecommender;

/**
 * ServletRecomendation
 */
@WebServlet("/recommendation")
public class ServletRecommendation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");
        RatingController ratingController = RatingController.getInstance();
        MovieController movieController = MovieController.getInstance();
        ratingController.readRatingFile("ratings", false);
        movieController.readMovieFile("movies", false);
        DecisionTreeRecommender decisionTreeRecommenderGender = new DecisionTreeRecommender(
                ratingController.getRatings(),
                "genre");
        DecisionTreeRecommender decisionTreeRecommenderNationality = new DecisionTreeRecommender(
                ratingController.getRatings(),
                "nationality");

        Map<String, String> userAttributesGenres = new HashMap<String, String>();
        Map<String, String> userAttributesNationality = new HashMap<String, String>();
        userAttributesGenres.put("genre", gender);
        userAttributesNationality.put("nationality", nationality);

        List<Recommendation> recommendationsNationality = decisionTreeRecommenderNationality
                .getRecommendations(userAttributesNationality);
        List<Recommendation> recommendationsGenres = decisionTreeRecommenderGender
                .getRecommendations(userAttributesGenres);

        List<Movie> moviesNationality = recommendationsNationality.stream()
                .map(item -> movieController.getMovieById(item.getItemId())).collect(Collectors.toList());
        List<Movie> moviesGenres = recommendationsGenres.stream()
                .map(item -> movieController.getMovieById(item.getItemId())).collect(Collectors.toList());

        HttpSession mSession = request.getSession();
        mSession.setAttribute("moviesNationality", moviesNationality);
        mSession.setAttribute("moviesGenres", moviesGenres);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/recommendation.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}