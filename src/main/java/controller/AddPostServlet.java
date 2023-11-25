package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import dao.PostDao;
import model.Post;
import model.User;
import helper.ConnectionProvider;

/**
 * Servlet implementation class AddPostServlet
 */
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String type = request.getParameter("option");
		Part img = request.getPart("img");
		InputStream is = img.getInputStream();
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
//        getting currentuser id
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//        out.println("your post title is " + pTitle);
//        out.println(part.getSubmittedFileName());
        Post p = new Post(user.getId() , is, sqldate, type, title, desc);
        PostDao dao = new PostDao(ConnectionProvider.getConnection());
        if (dao.insertPost(p)) {

        	request.getRequestDispatcher("/categories.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/post.jsp").forward(request, response);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String type = request.getParameter("option");
		Part img = request.getPart("img");
		InputStream is = img.getInputStream();
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
//        getting currentuser id
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//        out.println("your post title is " + pTitle);
//        out.println(part.getSubmittedFileName());
        Post p = new Post(user.getId() , is, sqldate, type, title, desc);
        PostDao dao = new PostDao(ConnectionProvider.getConnection());
        if (dao.insertPost(p)) {

        	request.getRequestDispatcher("/categories.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/post.jsp").forward(request, response);
        }
	}

}
