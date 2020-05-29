package modify.action;

import java.text.ParseException;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ModelDriven;

import modify.service.UserDAO;
import modify.service.impl.UserDAOImpl;

import modify.entity.User;

public class UserAction extends SuperAction implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();//ʹ��ģ������������ʵ����Users���󣬿��Բ���getter/setter��װ

	//�����޸ĺ���û�����
	public String save() throws ParseException {
		User u  = (User)session.getAttribute("modify_User");
		u.setUserName(request.getParameter("userName"));
		u.setUserNickName(request.getParameter("userNickName"));
		if(request.getParameter("gender").equals("Ů"))
			u.setGender(true);
		else
			u.setGender(false);
		//u.setUserAvatar(request.getParameter("userAvatar"));
		u.setPhone(request.getParameter("phone"));
		u.setWechat(request.getParameter("wechat"));
		u.setEMail(request.getParameter("EMail"));
		u.setPassword(request.getParameter("password"));
		u.setIdcardNumber(request.getParameter("idcardNumber"));
		UserDAO udao = new UserDAOImpl();
		udao.updateUser(u);
		return "save_success";
	}
	
	public User getModel() {
		// TODO Auto-generated method stub
		if(null == user){
			return user = new User();
		}
		return user;
	}

	//�˷���������еı�������֤
	public void validateSave() {
		System.out.println("validating!");
		
		/*
		 * ��֤�û���
		 * �û�������Ϊ��
		 */
		if("".equals(user.getUserName().trim())) {
			this.addFieldError("userName", "�û�������Ϊ�գ�");
		}
		
		/*
		 * ��֤�ǳ�
		 * �ǳƲ���Ϊ��
		 */
		if("".equals(user.getUserNickName().trim())) {
			this.addFieldError("userNickName", "�ǳƲ���Ϊ�գ�");
		}
		//�ǳƸ�ʽ
		else if(!Pattern.matches("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$", user.getUserNickName())) {
			this.addFieldError("userNickName", "�ǳƳ��ȱ�����5-20֮�䣬������ĸ��ͷ���ɴ����֡�_��.���ַ�����");
		}
		
		/*
		 * ��֤�绰����
		 * �绰����Ϊ��
		 */
		if("".equals(user.getPhone().trim())) {
			this.addFieldError("phone", "�ֻ����벻��Ϊ�գ�");
		}
		//�绰��ʽ
		else if(!Pattern.matches("^1[358]\\d{9}$", user.getPhone())) {
			this.addFieldError("phone", "�ֻ������ʽ����ȷ!");
		}
		
		/*
		 * ��֤΢��
		 * ΢�Ų���Ϊ��
		 */
		if("".equals(user.getWechat().trim())) {
			this.addFieldError("wechat", "΢�źŲ���Ϊ�գ�");
		}
		//΢�Ÿ�ʽ
		else if(!Pattern.matches("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,19}$", user.getWechat())) {
			this.addFieldError("wechat", "΢�źų��ȱ�����6-20֮�䣬������ĸ��ͷ���ɴ����֡�_��.���ַ�����");
		}
		
		/*
		 * ��֤����
		 * ���䲻��Ϊ��
		 */
		if("".equals(user.getEMail().trim())) {
			this.addFieldError("EMail", "���䲻��Ϊ�գ�");
		}
		//�����ʽ
		else if(!Pattern.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", user.getEMail())) {
			this.addFieldError("EMail", "�����ʽ����ȷ��");
		}
		
		/*
		 * ��֤���֤����
		 */
		if("".equals(user.getIdcardNumber().trim())) {
			this.addFieldError("idcardNumber", "���֤���벻��Ϊ�գ�");
		}
		//���֤�����ʽ
		else if(!Pattern.matches("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|", user.getIdcardNumber())) {
			System.out.println("idcard Wrong");
			this.addFieldError("idcardNumber", "���֤�����ʽ����ȷ��");
		}
		
		//�õ��޸�ǰ�����ݣ�����ID��ͷ����Ϣ
		User u  = (User)session.getAttribute("modify_User");
		user.setUserAvatar(u.getUserAvatar());
		user.setUserId(u.getUserId());
		//�ѵ�ǰ������Ϣ��д��session�������û���д
		session.setAttribute("modify_User", user);
	}
}
