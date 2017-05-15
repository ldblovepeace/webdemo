package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DBServlet
 */
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//用于数据库链接的connection对象
	protected Connection conn = null;
	//执行各种sql语句的方法
	protected ResultSet execSql(String sql, Object...args) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < args.length; i++){
			pstmt.setObject(i+1, args[i]);    //设置sql参数值
		}
		pstmt.execute();
		return pstmt.getResultSet();
	}
	//核对用户输入的验证码是否合法
	protected boolean checkValidationCode(HttpServletRequest request, String validationCode){
		String validationCodeSession = (String)request.getSession().getAttribute("validation_code");
		//如果获得的验证码为null，说明验证码过期，用户必须刷新客户端界面，重新获得验证码
		if(validationCodeSession == null){
			request.setAttribute("info", "validation code is out of date!");
			request.setAttribute("codeError", "validation code is out of date!");
			return false;
		}
		//将用户输入的验证码与系统随机生成的验证码进行比较
		if(!validationCodeSession.equalsIgnoreCase(validationCode)){
			request.setAttribute("info", "validation code is not correct!");
			request.setAttribute("codeError", "validation code is not correct!");
			return false;
		}
		return true;
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
			//如果conn是null打开数据库链接
			if(conn == null){
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/webdemo");
				conn = ds.getConnection();
			}
		}catch(Exception e){
			out.println(e);
		}
	}
	
	public void destroy(){
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
		}
	}
}
