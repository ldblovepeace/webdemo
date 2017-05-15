package chapter8.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action {
	
	private String username;
	private String password;
	
	private static Map<String, String> users = new HashMap<String, String>();
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	static{
		users.put("bill", "1234");
		users.put("mike", "4321");
	}
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			ActionContext ctx = ActionContext.getContext();
			Map<String, Object> application = ctx.getApplication();
			Map<String, Object> session = ctx.getSession();
			Integer counter = (Integer) application.get("counter");
			session.put("username", getUsername());
			String pw = users.get(username);
			if(pw == null){
				ctx.put("info", "该用户不存在，登陆失败！");
				return ERROR;
			}
			else{
				if(pw.equals(getPassword())){
					if(counter == null){
						counter = 1;
					}
					else{
						counter++;
					}
					application.put("counter", counter);
					ctx.put("info", "已成功登陆！");
					return SUCCESS;
				}
				else{
					ctx.put("info", "该用户不存在，登录失败！");
					return ERROR;
				}
			}
		}catch(Exception e){
			return ERROR;
		}
	}
	
}
