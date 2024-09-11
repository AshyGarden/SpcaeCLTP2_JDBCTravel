package com.space.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	//변할 일이 없는 변수 = static final
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static final String USERNAME = "jdbctravel";
	private static final String PASSWORD = "travel";
	
	public static Connection getDataSource() {
		
		Connection connection = null;
		
		try {
			Class.forName(DRIVER); 
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
