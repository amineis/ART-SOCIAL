package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Comment;
import model.User;

import java.io.IOException;

import dao.CommentDao;
import helper.ConnectionProvider;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comm = request.getParameter("comm");
		int authid = Integer.parseInt(request.getParameter("auth_id"));
		int pid = Integer.parseInt(request.getParameter("p_id"));
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Comment c = new Comment(authid, pid, comm);
        CommentDao cd = new CommentDao(ConnectionProvider.getConnection());
        if (cd.insertComment(c)) {
        	request.getRequestDispatcher("/details.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        }
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comm = request.getParameter("comm");
		int authid = Integer.parseInt(request.getParameter("auth_id"));
		int pid = Integer.parseInt(request.getParameter("p_id"));
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Comment c = new Comment(authid, pid, comm);
        CommentDao cd = new CommentDao(ConnectionProvider.getConnection());
        if (cd.insertComment(c)) {
        	request.getRequestDispatcher("/details.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        }	
	}

}
