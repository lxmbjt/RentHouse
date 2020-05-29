package modify.service;

import modify.entity.User;

//用户业务逻辑接口
public interface UserDAO {

//	//用户登录方法
//	public boolean userLogin(User u);
	
	//根据用户id查询用户资料
	public User queryUserByUid(int userId);
	
	//修改用户资料
	public boolean updateUser(User u);
}
