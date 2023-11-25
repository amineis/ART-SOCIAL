package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import dao.CommentDao;
import model.Comment;

import java.io.IOException;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 5;
		String title = "Title1";
		HttpSession s = request.getSession();
        User user = (User) s.getAttribute("user");
        s.setAttribute("title", title);
        s.setAttribute("id", id);

        response.sendRedirect("details.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		HttpSession s = request.getSession();
        User user = (User) s.getAttribute("user");
        response.sendRedirect("details.jsp");
	}

}
