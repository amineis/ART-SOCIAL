package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.mysql.cj.protocol.Message;

import dao.UserDao;
import model.User;
import helper.ConnectionProvider;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class EditProfileServlet
 */

@MultipartConfig
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        Part img = request.getPart("img");
		InputStream is = img.getInputStream();

        HttpSession s = request.getSession();
        User user = (User) s.getAttribute("user");
        user.setEmail(email);
        user.setName(name);
        user.setMdp(pass);
        user.setUsername(username);
        user.setGender(gender);
        user.setCountry(country);
        
        UserDao userDao = new UserDao(ConnectionProvider.getConnection());

        if (userDao.updateUser(user)) {

        	response.sendRedirect("viewprofile.jsp");
        } else {
            String msg = "Something went wrong..";
            s.setAttribute("msg", msg);
            response.sendRedirect("editprofile.jsp");

        }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        Part img = request.getPart("img");
		InputStream is = img.getInputStream();

        HttpSession s = request.getSession();
        User user = (User) s.getAttribute("user");
        user.setEmail(email);
        user.setName(name);
        user.setMdp(pass);
        user.setUsername(username);
        user.setGender(gender);
        user.setCountry(country);
        user.setImage(is);
        
        UserDao userDao = new UserDao(ConnectionProvider.getConnection());

        boolean ans = userDao.updateUser(user);
        if (ans) {

        	response.sendRedirect("viewprofile.jsp");
        } else {
            String msg = "Something went wrong..";
            s.setAttribute("msg", msg);
            response.sendRedirect("editprofile.jsp");

        }
	}

}
