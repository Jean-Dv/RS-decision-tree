package co.edu.uptc.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String genderMovie = request.getParameter("genderMovie");

        String urlToRecommendation = "/rs_decision_tree/recommendation";
        urlToRecommendation += "?name=" + name;
        urlToRecommendation += "&lastName=" + lastName;
        urlToRecommendation += "&gender=" + gender;
        urlToRecommendation += "&nationality=" + nationality;
        urlToRecommendation += "&genderMovie=" + genderMovie;

        if (name == null || name.trim().isEmpty() ||
                lastName == null || lastName.trim().isEmpty() ||
                gender == null || gender.trim().isEmpty() ||
                nationality == null || nationality.trim().isEmpty() || genderMovie.trim().isEmpty()) {

            // Datos incompletos, enviar mensaje de error
            request.setAttribute("errorMessage", "Error: All fields are required");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/adduser.jsp");
            requestDispatcher.forward(request, response);
            return;
        } else if (!name.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$")) {
            // Validar solo si el nombre no contiene solo letras
            request.setAttribute("error1", "only letters.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/adduser.jsp");
            requestDispatcher.forward(request, response);
            return;

        } else if (!lastName.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$")) {
            request.setAttribute("error2", "only letters.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/adduser.jsp");
            requestDispatcher.forward(request, response);
            return;

        } else {
            UserController uc = UserController.getInstance();
            uc.readUserFile("users", true);
            int id = uc.getUsers().get(uc.getUsers().size() - 1).getUserId() + 1;
            User user = new User(id, name, lastName, gender, nationality, genderMovie);

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