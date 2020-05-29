package modify.entity;

import java.util.HashSet;
import java.util.Set;

//”√ªß¿‡
public class User{
	
	private int userId;
	private String userName;
	private String userNickName;
	private Boolean gender;
	private String userAvatar;
	private String phone;
	private String wechat;
	private String EMail;
	private String password;
	private String idcardNumber;
	private Set houses = new HashSet();
	private Set reservationsForFUserIdRent = new HashSet();
	private Set favorites = new HashSet();
	private Set reservationsForFUserIdOwner = new HashSet();

	public User(){
		
	}
	
	public User(int userId, String userName, String userNickName, Boolean gender,
			String userAvatar, String phone, String wechat, String eMail,
			String password, String idcardNumber) {
		//super();
		this.userId = userId;
		this.userName = userName;
		this.userNickName = userNickName;
		this.gender = gender;
		this.userAvatar = userAvatar;
		this.phone = phone;
		this.wechat = wechat;
		this.EMail = eMail;
		this.password = password;
		this.idcardNumber = idcardNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdcardNumber() {
		return idcardNumber;
	}

	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}
	
	public Set getHouses() {
		return houses;
	}
	
	public void setHouses(Set houses) {
		this.houses = houses;
	}

	public Set getReservationsForFUserIdRent() {
		return reservationsForFUserIdRent;
	}

	public void setReservationsForFUserIdRent(Set reservationsForFUserIdRent) {
		this.reservationsForFUserIdRent = reservationsForFUserIdRent;
	}

	public Set getFavorites() {
		return favorites;
	}

	public void setFavorites(Set favorites) {
		this.favorites = favorites;
	}

	public Set getReservationsForFUserIdOwner() {
		return reservationsForFUserIdOwner;
	}

	public void setReservationsForFUserIdOwner(Set reservationsForFUserIdOwner) {
		this.reservationsForFUserIdOwner = reservationsForFUserIdOwner;
	}
	
}
