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
public class NewPasswordAction extends ActionSupport implements ModelDriven<User> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String result ;
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
		try{
			userDao.newPassword(user);
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		result = "用户<" + user.getUsername() + ">密码修改成功";
		return SUCCESS;
	}

}
