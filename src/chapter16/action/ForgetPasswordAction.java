/**
 * 
 */
package chapter16.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import chapter16.dao.UserDaoImpl;
import chapter16.model.User;

/**
 * @author liudongbing
 *
 */
public class ForgetPasswordAction extends ActionSupport implements ModelDriven<User>, ServletRequestAware, ServletResponseAware {

	
	private User user = new User();
	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public User getModel() {
		return user;
	}
	
	public String execute() throws Exception{
		//System.out.print(user.getValidationCode()+user.getTextcode());
		Object obj = ActionContext.getContext().getSession().get("validation_code");
		String validationCode = (obj !=null) ? obj.toString() : "";
		if(!validationCode.equalsIgnoreCase(user.getValidationCode())){
			if(user.getValidationCode()!=null){
				this.addActionError("验证码不正确");
			}
			else this.addActionError("请填写验证码");
			return INPUT;
		}
		Object obj1 = ActionContext.getContext().getSession().get("textcode");
		String textCode = (obj1 !=null)?obj1.toString() : "";
		if(!textCode.equals(user.getTextcode())){
			if(user.getTextcode() != null){
				this.addActionError("短信验证码错误");
			}
			else this.addActionError("请填写短信验证码");
			return INPUT;
		}
		else return "confirm";
	}
	
}
