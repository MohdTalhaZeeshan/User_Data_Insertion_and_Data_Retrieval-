package com.user.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsersLogin")
public class UsersDaoInsert extends HttpServlet 
{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		                   
		String name= request.getParameter("name");
		String email=request.getParameter("emailId");
		String ageString=request.getParameter("age");
		int age=Integer.parseInt(ageString);
	    String dateInString=request.getParameter("DOB");
	    Date dob=Date.valueOf(dateInString);
	      PrintWriter writer= response.getWriter();
	      response.setContentType("text/html");
	      
	   
	    
	    
	       
String insert="insert into user(userName, userEmailId, userAge, userDOB) values(?,?,?,?)";
		
		
		
		try {
			
			
			 
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/teca54?user=root&password=12345");
			 PreparedStatement      ps=  connection.prepareStatement(insert);
			 
			 ps.setString(1, name);
			 
			 if(email.contains("@gmail.com"))
				{
				 ps.setString(2, email);
				}
			    else
			    {
			    	
			    	writer.println(" <center> <h1 style='color:red;'> Invalid EmailId </h1></center>");
			    }
			
			 if(age>0)
			    {
				 ps.setInt(3, age);
			    }
			    else
			    {
			    	
			    	writer.println("<center> <h1 style='color:red;'> Age Should be Positive ");
			    }
			
			 ps.setDate(4, dob);
			 
			  int    result=  ps.executeUpdate();
			  if(result!=0)
			  {
				  writer.println("<center> <h1 >Data Inserted Successfully </h1></center>");
			  }
			  else
			  {
				  writer.println(" <center> <h1> Data Not Inserted  </h1></center>");
			  }
			 
			 
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
			     	
	}
}

  
	 
	  
	  
