package struts2.dao;

import struts2.vo.User;

public interface UserDAO {
	public User Login(User user) throws Exception;
	public int Register(User user) throws Exception;
	
}
