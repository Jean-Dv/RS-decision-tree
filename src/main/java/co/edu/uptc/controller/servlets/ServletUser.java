package co.edu.uptc.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.User;

@WebServlet("/hello")
public class ServletUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");

        if (name == null || lastName == null || gender == null || nationality == null) {
            // Datos incompletos, enviar mensaje de error
            response.getWriter().println("Error: Todos los campos son obligatorios");
            return;

        } else {
            User user = new User(12, name, lastName, gender, nationality);

            UserController uc = new UserController();
            uc.addUser(user, "users");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        User user = new User(2, "juan2", "fernande", "male", "colobia");
        User user1 = new User(2, "david", "fernande", "male", "colobia");
        User user2 = new User(2, "jjsdsd", "fernande", "male", "colobia");

        users.add(user);
        users.add(user1);
        users.add(user2);

        HttpSession mSession = request.getSession();
        mSession.setAttribute("users", users);
        response.sendRedirect(request.getContextPath() + "/pages/showrecomendations.jsp");

    }

}