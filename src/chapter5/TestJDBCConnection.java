package chapter5;

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
 * Servlet implementation class ViewDept
 */
public class TestJDBCConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/webdemo");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from dept");
			ResultSet rs = pstmt.executeQuery();
			StringBuilder table = new StringBuilder();
			table.append("<table border='1'>");
			table.append("<tr>"
					+ "<td>location</td>"
					+ "<td>dep_name</td>"
					+ "<td>age</td>"
					+ "</tr>");
			while(rs.next()){
				table.append("<tr>"+ "<td>"+rs.getString("Loc")+"</td>");
				table.append("<td>"+rs.getString("Name")+"</td>");
				table.append("<td>"+ rs.getString("Age")+"</td>"+ "</tr>");
				
			}
			table.append("</table>");
			out.println(table.toString());
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			out.println(e.getMessage());
		}
	}
 
}
