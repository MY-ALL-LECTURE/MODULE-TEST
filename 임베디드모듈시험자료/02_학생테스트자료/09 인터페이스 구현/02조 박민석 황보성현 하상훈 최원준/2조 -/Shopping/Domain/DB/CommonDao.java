package Domain.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDao {
	protected Connection conn =null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	private DBConn dbConn = null;
	protected CommonDao() throws Exception {
		dbConn = DBConn.getInstance();
		conn = dbConn.getConnection();
	}
	
	public void freeConnection(Connection conn) throws SQLException {
		conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
		conn.close();
	}
	public void freeConnection(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close();
		conn.close();
	}
	public void freeConnection(PreparedStatement pstmt) throws SQLException {
		pstmt.close(); 
	}
	public void freeConnection(PreparedStatement pstmt,ResultSet rs) throws SQLException {
		rs.close();
		pstmt.close(); 
	}	
}
