package com.postassessment3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/accountregistration")
public class AccountRegistrationController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String city=request.getParameter("city");
		String gender=request.getParameter("gender");
		try {
			//Load the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Get connection to Oracle DB
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");  
			
			//Create Statement
			Statement statement = connection.createStatement();
			
			String queryString = "insert into account values('" + firstName + "', '" + lastName + "', '" + city + "', '" + gender + "')" ;
			System.out.println(queryString);
			int noOfRowsInserted = statement.executeUpdate(queryString);
			if(noOfRowsInserted ==1) {
				System.out.println("NO OF ROWS INSERTED : " + noOfRowsInserted);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			else {
				System.out.println("No rows inserted!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.html");
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.html");
			requestDispatcher.forward(request, response);
		}	
	}
}
