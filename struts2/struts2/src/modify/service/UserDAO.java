package modify.service;

import modify.entity.User;

//�û�ҵ���߼��ӿ�
public interface UserDAO {

//	//�û���¼����
//	public boolean userLogin(User u);
	
	//�����û�id��ѯ�û�����
	public User queryUserByUid(int userId);
	
	//�޸��û�����
	public boolean updateUser(User u);
}
