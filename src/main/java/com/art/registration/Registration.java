package com.art.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/art","root","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO signup (name, email, pass) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, pass);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while trying to sign up");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        } catch (Exception e) {
			e.printStackTrace();
		}
        request.getRequestDispatcher("/login.jsp").forward(request, response);
	
	}

}
