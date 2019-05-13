package com.webservices.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle308tube {

	
	private Connection con = null;

	public static final String DB_URL = "com.mysql.jdbc.Driver";
	public static final String DRIVER_NAME = "jdbc:mysql://localhost:3306/mydatabase";
	
	public Connection getConnection() throws ClassNotFoundException,SQLException {
	Class.forName(DB_URL);  
	con = DriverManager.getConnection(DRIVER_NAME, "root", "Welcome123");
	
	System.out.println("Connection established");
	return con;
	}
}
