package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import dao.UserDao;
import model.User;
import helper.ConnectionProvider;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        UserDao dao = new UserDao(ConnectionProvider.getConnection());

        User u = dao.getUserByEmailAndPassword(email, pass);

        if (u == null) {
            response.sendRedirect("login.jsp");
        } else {
            HttpSession s = request.getSession();
            s.setAttribute("user", u);
            response.sendRedirect("index.jsp");

        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        UserDao dao = new UserDao(ConnectionProvider.getConnection());

        User u = dao.getUserByEmailAndPassword(email, pass);

        if (u == null) {
            response.sendRedirect("login_page.jsp");
        } else {
            HttpSession s = request.getSession();
            s.setAttribute("user", u);
            response.sendRedirect("index.jsp");

        }
	}

}
