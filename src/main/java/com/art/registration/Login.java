package com.art.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();		
		RequestDispatcher dispatcher = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/art","root","");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM signup WHERE email=? AND pass=?");
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
            	session.setAttribute("name", rs.getString("name"));
            	dispatcher = request.getRequestDispatcher("index.jsp");
            }else {
            	dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
            
        }catch (Exception e) {
			e.printStackTrace();
		}
	}

}
