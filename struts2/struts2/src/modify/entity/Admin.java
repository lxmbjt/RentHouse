package modify.entity;

//管理员类
public class Admin {
	
	private int adminId;
	private String password;
	
	public Admin(){
		
	}

	public Admin(int adminId, String password) {
		//super();
		this.adminId = adminId;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
