/**
 * 
 */
package chapter16.action;



import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import chapter16.dao.UserDaoImpl;
import chapter16.model.MailSenderInfo;
import chapter16.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import common.SimpleMailSender;

/**
 * @author liudongbing
 *
 */
public class SendTextAction extends ActionSupport implements ModelDriven,
ServletResponseAware, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */

	private HttpServletRequest request;
	private HttpServletResponse response;
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	private User user = new User();
	private String result;
	private int textcode;
	@Override
	public Object getModel() {
		return user;
	}
	
	/*public String confirm(){
		Object obj = ActionContext.getContext().getSession().get("textcode");
		String textCode = (obj !=null)?obj.toString() : "";
		if(!textCode.equals(user.getTextcode())){
			if(user.getTextcode() != null){
				this.addActionError("短信验证码错误");
			}
			return INPUT;
		}
		else return "confirm";
	}*/
	
	public String execute() throws Exception{
		UserDaoImpl userDao = new UserDaoImpl();
		try{
			textcode =RandomCode();
			//里面写发送短信的接口，现在还没有办法 
			System.out.print("假装发了一条短信:" + textcode);
			MailSenderInfo mailInfo = new MailSenderInfo();
	        mailInfo.setMailServerHost("mail.sgjtsteel.com");
	        mailInfo.setMailServerPort("25");
	        mailInfo.setValidate(true);
	        mailInfo.setFromAddress("l_dongbing@sgjtsteel.com");
	        mailInfo.setToAddress(userDao.returnEmail(user));
	        mailInfo.setUserName("l_dongbing");
	        mailInfo.setPassword("853126656");
	        mailInfo.setSubject("修改"+user.getSystem()+"密码验证码");
	        mailInfo.setContent("验证码是"+textcode);
	        SimpleMailSender.sendTextMail(mailInfo);
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("textcode", textcode);
		}catch(Exception e){
			this.addActionError(e.getMessage());
		}
		
		result = "向用户"+user.getUsername()+"的邮箱"+userDao.returnEmail(user)+"发送了一条验证码";
		return SUCCESS;
	}
	//生成随机验证码
	public int RandomCode(){
		int randomcode= new Random().nextInt(999999);
		return randomcode;
	}
	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}
}
