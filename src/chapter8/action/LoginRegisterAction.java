package chapter8.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.Action;

public class LoginRegisterAction implements Action {

	private String username;
	private String password;
	private String result;
	
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
	public String getResult(){
		return result;
	}
	public void setResult(String result){
		this.result = result;
	}
	
	
	static{
		users.put("bill", "1234");
		users.put("mike", "4321");
	}

	public String register() throws Exception{
		return "register";
	}
	public String login() throws Exception{
		System.out.println("login");
		return execute();
	}
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
