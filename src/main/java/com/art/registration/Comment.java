package com.art.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comm = request.getParameter("comm");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/art","root","");
            PreparedStatement st = connection.prepareStatement("INSERT INTO commentaire(author_id ,c_post_id ,content) VALUES(?,?,?)");
            PreparedStatement st1 = connection.prepareStatement("SELECT * FROM signup WHERE id = ?");
            st.setInt(1, 1);
            st.setInt(2, 5);
            st.setString(3, comm);
            st1.setInt(1, 1);
            ResultSet rs = st1.executeQuery();
            int res = st.executeUpdate();
            PrintWriter out = response.getWriter();
            if(rs.next()){
            	request.setAttribute("username", rs.getString("name"));
            	request.setAttribute("comm", comm);
            	dispatcher = request.getRequestDispatcher("details.jsp");
            }else {
            	dispatcher = request.getRequestDispatcher("login.jsp");
            } 
            dispatcher.forward(request, response);
        }catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
