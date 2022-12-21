package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		 String jdbcURL = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker";
		 String jdbcUsername = "hbstudent";
		 String jdbcPassword = "hbstudent";
		 
		 
			try {
				System.out.println("connecting to database : "+jdbcURL); 
				Connection  myConn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				System.out.println("connection succesfull"); 
				
			} 
			catch (SQLException e) {	
				e.printStackTrace();
			}
			
	}

}
