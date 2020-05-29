package struts2.action;

import java.util.Map;   

import struts2.dao.OwnerDAO;
import struts2.dao.impl.OwnerDAOImpl;
import struts2.vo.User;
  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class CopyOfPersonAction extends ActionSupport{   
  
   
	private static final long serialVersionUID = 1L;
	private User user;   
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
  
    public String execute() throws Exception {   

        String id= session.get("user_id").toString();
        OwnerDAO dao = new OwnerDAOImpl();   
        
		String re=dao.PersonHouse(Integer.parseInt(id));
		String ordered=dao.PersonOrder(Integer.parseInt(id));
		String order=dao.PersonOrdered(Integer.parseInt(id));
		String star=dao.PersonStar(Integer.parseInt(id));
        session.put("PersonHouse", re);
        
        if (re !=""){   
            
            session.put("PersonHouse", re);   

           
        } else {   
        	session.put("PersonHouse", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">����û���ϴ���Դ</div>");   
        }   
        if ( ordered !=""){   
            
            session.put("PersonOrder",  ordered);   

           
        } else {   
        	session.put("PersonOrder", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">����û�з���ԤԼ</div>");   
        }   
        if ( order !=""){   
            
            session.put("PersonOrdered",  order);   

           
        } else {   
        	session.put("PersonOrdered", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">��û����ԤԼ��</div>");   
        } 
        if ( star !=""){   
            
            session.put("PersonStar",  star);   

           
        } else {   
        	session.put("PersonStar", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">�ղؼ�Ϊ��</div>");   
        } 
		return "success";
        
      
    }
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}





    
}  

