package es.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		String jdbUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "";
		
		try {
			System.out.println("Connection to database " + jdbUrl);
			
			Connection myConn = DriverManager.getConnection(jdbUrl, user, pass);
			System.out.println("Connection successfull!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
