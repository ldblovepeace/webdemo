package chapter16.dao.interfaces;

import chapter16.model.User;

public interface UserDao {
	public boolean validateUser(User user) throws Exception;
	public void addUser(User user) throws Exception;
	//public String returnPhonenum(User user) throws Exception;
	public void newPassword(User user) throws Exception;
	/**
	 * @param user
	 * @return
	 * @throws Exception
	 */
	String returnEmail(User user) throws Exception;
}
