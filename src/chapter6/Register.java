package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends DBServlet {
	private static final long serialVersionUID = 1L;

	//@SuppressWarnings("finally")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = null;
		PrintWriter out = response.getWriter();
		if(request.getParameter("login") !=null){
			response.sendRedirect("login.jsp");
		}
		try{
			super.service(request, response);
			userName = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String validationCode = request.getParameter("validation_code");
			out.println(password+userName+email+validationCode);
			//用户名和密码必须输入，不能为空
			if(userName == null||password == null||validationCode == null){
				out.println("yonghumingmima doumeiyou");
				return;
			}
			if(userName.equals("")||password.equals("")||validationCode.equals("")){
				return;
			}
			//编码转换，支持中文用户名
			userName = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
			//在result.jsp中跳转到register。jsp
			request.setAttribute("page", "login.jsp");
			//核对验证码
			if(!checkValidationCode(request,validationCode)){
				return;
			}
			email = (email == null)?"":email;
			String passwordMD5 = common.Encrypter.md5Encrypt(password);
			//定义插入记录的sql语句
			String sql="insert into t_user(user_name, password_md5,email) values(?,?,?)";
			//执行sql语句
			execSql(sql,userName,passwordMD5,email);
			request.setAttribute("info", "user registered successfully!");
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.setAttribute("info", userName+" already been used");
		}
		finally{
			//转发到result。jsp
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request,response);
			//return;
		}
	}
}
