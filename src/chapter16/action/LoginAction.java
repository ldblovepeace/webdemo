/**
 * 
 */
package chapter16.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import chapter16.dao.UserDaoImpl;
import chapter16.dao.interfaces.UserDao;
import chapter16.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author liudongbing
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private HttpServletRequest request;
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public void setServletRequset(HttpServletRequest request){
		this.request = request;
	}
	public String execute() throws Exception{
		UserDao userDao = new UserDaoImpl();
		//从session中获得验证码
		Object obj = ActionContext.getContext().getSession().get("validation_code");
		String validationCode = (obj !=null)?obj.toString() : "";
		if(!validationCode.equalsIgnoreCase(user.getValidationCode())){
			if(user.getValidationCode() != null){
				this.addActionError("验证码错误");
			}
			return INPUT;
		}
		
		if(!userDao.validateUser(user)){
			this.addActionError("用户名或密码错误");
			return INPUT;
		}
		
//		HttpSession session = request.getSession();
//		session.setAttribute("username", user.getUsername());
//		session.setMaxInactiveInterval(60*60*3);
		return SUCCESS;
	}

}
