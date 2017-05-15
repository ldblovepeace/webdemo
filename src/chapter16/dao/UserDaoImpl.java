/**
 * 
 */
package chapter16.dao;

import java.sql.ResultSet;
import common.Encrypter;

import chapter16.dao.interfaces.UserDao;
import chapter16.model.User;

/**
 * @author liudongbing
 *
 */
public class UserDaoImpl extends DaoSupport implements UserDao {

	@Override
	public boolean validateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			ResultSet rs = this.execSQL("select password_md5 from t_user where user_name=?", user.getUsername());
			if(rs.next()){
				String password_md5 = Encrypter.md5Encrypt(user.getPassword());
				if(password_md5.equals(rs.getString("password_md5"))){
					return true;
				}
			}
		}
		catch (Exception e){
		}
		finally{
			close();
		}
		return false;
	}

	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			String password_md5 = Encrypter.md5Encrypt(user.getPassword());
			this.execSQL("insert into t_user(user_name,password_md5,email,system,phone_num) values(?,?,?,?,?)", user.getUsername(),password_md5, user.getEmail(),user.getSystem(),user.getPhonenum());
		}
		catch(Exception e){
			throw new Exception("注册用户异常");
		}
		finally{
			close();
		}
	}

	/* (non-Javadoc)
	 * @see chapter16.dao.interfaces.UserDao#returnPhonenum(chapter16.model.User)
	 */
	@Override
	public String returnEmail(User user) throws Exception {
		try{
			ResultSet rs = this.execSQL("select email from t_user where user_name=?", user.getUsername());
			if(rs.next()){
				return rs.getString("email");		
			}
		}
		catch (Exception e){
		}
		finally{
			close();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see chapter16.dao.interfaces.UserDao#newPassword(chapter16.model.User)
	 */
	@Override
	public void newPassword(User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			String password_md5 = Encrypter.md5Encrypt(user.getNewpassword());
			this.execSQL("update t_user set password_md5=? where user_name=? and system=?",password_md5 ,user.getUsername(), user.getSystem());
		}catch(Exception e){
			throw new Exception("修改密码异常");
		}
		finally{
			close();
		}
	}
	
}
