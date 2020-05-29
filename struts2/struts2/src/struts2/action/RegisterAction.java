package struts2.action;



import struts2.dao.UserDAO;
import struts2.dao.impl.UserDAOImpl;
import struts2.vo.User;
  

import com.opensymphony.xwork2.ActionSupport;
  
public class RegisterAction extends ActionSupport{   
  
   
	private static final long serialVersionUID = 1L;
	private User user;   

   // private static final long serialVersionUID = 1L;   
  
    public String execute() throws Exception {   
        UserDAO dao = new UserDAOImpl();   
        int re = dao.Register(user);  
        System.out.println(re);
        if(re==1){   
        	 
        	 
            return "success";
        } else if(re==2) {   
        	this.addActionError("�õ绰������ע��");
            return "input";   
        }  
        else if(re==3){
        	this.addActionError("���벻һ��");
            return "input";   
        	
        }
        else{
        	
        	this.addActionError("����ȷ��������");
            return "input";  
        }
    }

    
   

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




  
  
    
}  

