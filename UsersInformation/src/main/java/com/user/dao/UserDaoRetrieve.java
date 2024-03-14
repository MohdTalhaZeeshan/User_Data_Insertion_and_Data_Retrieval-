package com.user.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/retrive")
public class UserDaoRetrieve extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String select="select * from user where userName=? ";
		  
		  try {
			PrintWriter writer=response.getWriter();
			
			response.setContentType("text/html");
			  
			  Connection connection;
		
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teca54?user=root&password=12345");
		 PreparedStatement      ps=  connection.prepareStatement(select);	 
			
		          ps.setString(1, name);
		          
		         ResultSet resultSet = ps.executeQuery();
		         if(resultSet.next())
		         {
		        	 writer.println("<table style='border:5px black solid;border-collapse: collapse;'><tr><th style='border:5px black solid'>userId</th><th>userName</th><th style='border:5px black solid'>userEmailId</th><th style='border:5px black solid'>userAge</th><th style='border:5px black solid'>userDOB</th></tr> <tr><th style='border:5px black solid'> "+resultSet.getInt("userId")+" </th><th style='border:5px black solid'>"+resultSet.getString("userName")+"</th><th style='border:5px black solid'>"+resultSet.getString("userEmailId")+"</th><th style='border:5px black solid'>"+resultSet.getInt("userAge")+"</th><th style='border:5px black solid'>"+resultSet.getDate("userDOB")+"</th></tr>");
		         }
		         
		         else
		         {
		        	 
		        	 writer.println(" <center><h1>Invalid Name </h1> </center>");
		         }
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		  catch (IOException e) {
				
				e.printStackTrace();
			}
					
			}

		  
	}
	

