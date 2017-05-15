package chapter8.modeldriven;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserLogin> {
	
	private UserLogin model = new UserLogin();
	
	
	@Override
	public UserLogin getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	@Override
	public String execute() throws Exception {
		if(getModel().getUsername().equals("bill") && getModel().getPassword().equals("1234")){
			getModel().setResult("11111111111111111111111");
			return SUCCESS;
		}
		else{
			return ERROR;	
		}
	}

}
