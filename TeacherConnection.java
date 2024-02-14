package com.jsp.jdbc_prepared_crud_with_architecture.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class TeacherConnection {
	
	public static Connection getTeacherConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-930","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
