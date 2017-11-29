package br.ucb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/projetocitacao";
	private static final String USER = "root";
	private static final String PASS = "root";

	private static Connection conn;
	
	private ConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection(){
		try {
			if (conn == null || conn.isClosed()){
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(URL, USER, PASS);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}