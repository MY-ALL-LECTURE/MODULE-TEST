package Domain.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn = null;
	
	private static DBConn instance = null;
	public static DBConn getInstance() throws Exception {
		if(instance == null)
			instance = new DBConn();
		return instance;
	}
	
	private DBConn() {
		id = "root";
		pw = "1234";
		url = "jdbc:mysql://localhost:3306/Shopping";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected...");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Connection getConnection() {
		return conn;
	}
}
