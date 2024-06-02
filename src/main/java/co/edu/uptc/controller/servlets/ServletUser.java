package co.edu.uptc.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.User;

@WebServlet("/user")
public class ServletUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");

        String urlToRecommendation = "/rs_decision_tree/recommendation";
        urlToRecommendation += "?name=" + name;
        urlToRecommendation += "&lastName=" + lastName;
        urlToRecommendation += "&gender=" + gender;
        urlToRecommendation += "&nationality=" + nationality;

        if (name == null || name.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() ||
                gender == null || gender.trim().isEmpty() ||
                nationality == null || nationality.trim().isEmpty()) {

            // Datos incompletos, enviar mensaje de error
            request.setAttribute("errorMessage", "Error: All fields are required");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/adduser.jsp");
            requestDispatcher.forward(request, response);
            return;

        } else {
            User user = new User(12, name, lastName, gender, nationality);
            UserController uc = new UserController();
            uc.addUser(user, "users");
            response.sendRedirect(urlToRecommendation);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/adduser.jsp");
        requestDispatcher.forward(request, response);

    }
}