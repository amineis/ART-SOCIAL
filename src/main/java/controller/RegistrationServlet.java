package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;

import dao.UserDao;
import model.User;
import helper.ConnectionProvider;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        //create user object and set all data to that object..
        User user = new User(username, email, password);

        //create a user daao object..
        UserDao dao = new UserDao(ConnectionProvider.getConnection());
        if (dao.saveUser(user)) {
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        //create user object and set all data to that object..
        User user = new User(username, email, password);

        //create a user daao object..
        UserDao dao = new UserDao(ConnectionProvider.getConnection());
        if (dao.saveUser(user)) {
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
	}

}
