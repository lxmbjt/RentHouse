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
	private User user = new User();//使用模型驱动，必须实例化Users对象，可以不用getter/setter封装

	//保存修改后的用户资料
	public String save() throws ParseException {
		User u  = (User)session.getAttribute("modify_User");
		u.setUserName(request.getParameter("userName"));
		u.setUserNickName(request.getParameter("userNickName"));
		if(request.getParameter("gender").equals("女"))
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

	//此方法会对所有的表单进行验证
	public void validateSave() {
		System.out.println("validating!");
		
		/*
		 * 验证用户名
		 * 用户名不能为空
		 */
		if("".equals(user.getUserName().trim())) {
			this.addFieldError("userName", "用户名不能为空！");
		}
		
		/*
		 * 验证昵称
		 * 昵称不能为空
		 */
		if("".equals(user.getUserNickName().trim())) {
			this.addFieldError("userNickName", "昵称不能为空！");
		}
		//昵称格式
		else if(!Pattern.matches("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$", user.getUserNickName())) {
			this.addFieldError("userNickName", "昵称长度必须在5-20之间，且以字母开头，可带数字、_和.的字符串！");
		}
		
		/*
		 * 验证电话号码
		 * 电话不能为空
		 */
		if("".equals(user.getPhone().trim())) {
			this.addFieldError("phone", "手机号码不能为空！");
		}
		//电话格式
		else if(!Pattern.matches("^1[358]\\d{9}$", user.getPhone())) {
			this.addFieldError("phone", "手机号码格式不正确!");
		}
		
		/*
		 * 验证微信
		 * 微信不能为空
		 */
		if("".equals(user.getWechat().trim())) {
			this.addFieldError("wechat", "微信号不能为空！");
		}
		//微信格式
		else if(!Pattern.matches("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,19}$", user.getWechat())) {
			this.addFieldError("wechat", "微信号长度必须在6-20之间，且以字母开头，可带数字、_和.的字符串！");
		}
		
		/*
		 * 验证邮箱
		 * 邮箱不能为空
		 */
		if("".equals(user.getEMail().trim())) {
			this.addFieldError("EMail", "邮箱不能为空！");
		}
		//邮箱格式
		else if(!Pattern.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", user.getEMail())) {
			this.addFieldError("EMail", "邮箱格式不正确！");
		}
		
		/*
		 * 验证身份证号码
		 */
		if("".equals(user.getIdcardNumber().trim())) {
			this.addFieldError("idcardNumber", "身份证号码不能为空！");
		}
		//身份证号码格式
		else if(!Pattern.matches("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|", user.getIdcardNumber())) {
			System.out.println("idcard Wrong");
			this.addFieldError("idcardNumber", "身份证号码格式不正确！");
		}
		
		//得到修改前的数据，保留ID和头像信息
		User u  = (User)session.getAttribute("modify_User");
		user.setUserAvatar(u.getUserAvatar());
		user.setUserId(u.getUserId());
		//把当前所有信息再写回session，避免用户重写
		session.setAttribute("modify_User", user);
	}
}
