/**
 * 
 */
package chapter16.action;

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
public class RegisterAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	private String result;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String execute()throws Exception{
		UserDaoImpl userDao = new UserDaoImpl();
		Object obj = ActionContext.getContext().getSession().get("validation_code");
		String validationCode = (obj !=null) ? obj.toString() : "";
		if(!validationCode.equalsIgnoreCase(user.getValidationCode())){
			if(user.getValidationCode()!=null){
				this.addActionError("验证码不正确");
			}
			return INPUT;
		}
		try{
			userDao.addUser(user);
		}
		catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		result = "用户<" + user.getUsername() + ">注册成功";
		return SUCCESS;
	}
	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}
}
