package com.art.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

/**
 * Servlet implementation class Posting
 */
@WebServlet("/post")
@MultipartConfig
public class Posting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String type = request.getParameter("option");
		Part img = request.getPart("img");
		InputStream is = img.getInputStream();
		Date date = new Date();
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
			
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/art","root","");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO post(author_id,p_img,p_time,p_type,p_title,p_desc) VALUES(?,?,?,?,?,?)");

            statement.setInt(1, 1);
            statement.setBlob(2, is);
            statement.setDate(3, sqldate);
            statement.setString(4, type);
            statement.setString(5, title);
            statement.setString(6, desc);
            
            int res = statement.executeUpdate();
            if(res > 0){
            	request.getRequestDispatcher("/details.jsp").forward(request, response);
            }else {
            	request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
