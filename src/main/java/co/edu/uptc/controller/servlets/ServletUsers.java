package co.edu.uptc.controller.servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.uptc.controller.UserController;
import co.edu.uptc.model.User;

@WebServlet("/users")
public class ServletUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserController usersController = new UserController();
        usersController.readUserFile("users");
        ArrayList<User> listUsers = usersController.getUsers();
        Collections.reverse(listUsers);
        HttpSession mSession = request.getSession();
        mSession.setAttribute("listUsers", listUsers);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/users.jsp");
        requestDispatcher.forward(request, response);
    }

}
