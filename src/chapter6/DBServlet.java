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
	
	//�������ݿ����ӵ�connection����
	protected Connection conn = null;
	//ִ�и���sql���ķ���
	protected ResultSet execSql(String sql, Object...args) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < args.length; i++){
			pstmt.setObject(i+1, args[i]);    //����sql����ֵ
		}
		pstmt.execute();
		return pstmt.getResultSet();
	}
	//�˶��û��������֤���Ƿ�Ϸ�
	protected boolean checkValidationCode(HttpServletRequest request, String validationCode){
		String validationCodeSession = (String)request.getSession().getAttribute("validation_code");
		//�����õ���֤��Ϊnull��˵����֤����ڣ��û�����ˢ�¿ͻ��˽��棬���»����֤��
		if(validationCodeSession == null){
			request.setAttribute("info", "validation code is out of date!");
			request.setAttribute("codeError", "validation code is out of date!");
			return false;
		}
		//���û��������֤����ϵͳ������ɵ���֤����бȽ�
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
			//���conn��null�����ݿ�����
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
