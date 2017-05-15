package chapter16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoSupport {
	protected Connection conn = null;
	protected ResultSet execSQL(String sql, Object... args) throws Exception{
		openConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for(int i = 0;i<args.length;i++){
			pstmt.setObject(i+1, args[i]);
		}
		pstmt.execute();
		return pstmt.getResultSet();
	}
	private void openConnection(){
		try{
			if(conn == null){
				Context ctx =new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/webdemo");
				conn = ds.getConnection();
				}
		}catch(Exception e){
			
		}
	}
	public void close(){
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			
		}
	}
}
