package chapter6;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends DBServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("register")!=null){
			response.sendRedirect("register.jsp");
			return;
		}
		
		String page = "login.jsp";
		String userName ="";
		
		try{
			super.service(request, response);
			userName = request.getParameter("username");
			String password = request.getParameter("password");
			String validationCode = request.getParameter("validation_code");
		
			if(userName==null||password==null||validationCode==null){
				return;
			}
			if(userName.equals("")||password.equals("")||validationCode.equals("")){
				return;
			}
			if(!checkValidationCode(request,validationCode)){
				return;
			}
			
			String sql = "select user_name,password_md5 from t_user where user_name = ?";
			ResultSet rs = execSql(sql,new Object[]{userName});
			if(rs.next() == false){
				request.setAttribute("usernameError", userName+" is not exist!");
			}
			else{
				if(password.equals(rs.getString("password_md5"))){
					page = "main.jsp";
				}
				else{
					request.setAttribute("passwordError", "password is not correct!");
				}
			}
		}catch(Exception e){
		}
		finally{
			request.setAttribute("username", userName);
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}
}
