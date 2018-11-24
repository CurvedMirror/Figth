package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
	public Connection conn ; 
	public ResultSet rs ; 
	public PreparedStatement ps ; 
	
	public void getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int executeUpdate(String sql ,Object... params){
		int result =0;
		getConn();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			result = ps.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return result;
	}
	
	public ResultSet executeQuery(String sql ,Object... params){
		getConn();
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
//	/**
//	 * 需要重写的方法
//	 *
//	 * @param rs
//	 * @return
//	 * @throws Exception
//	 */
//	public abstract Object tableToClass(ResultSet rs) throws SQLException;

	
}
