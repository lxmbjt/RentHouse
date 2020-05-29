package struts2.action;


import com.opensymphony.xwork2.ModelDriven;



import java.util.Map;   

import modify.action.SuperAction;
import modify.entity.User;
import modify.service.UserDAO;
import modify.service.impl.UserDAOImpl;

import struts2.dao.OwnerDAO;
import struts2.dao.impl.OwnerDAOImpl;
  
import com.opensymphony.xwork2.ActionContext;   
  
public class PersonAction extends SuperAction{   
  
   
	private static final long serialVersionUID = 1L;
	private User user;   
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> sessionMap = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
  
    public String execute() throws Exception {   

        String id= sessionMap.get("user_id").toString();
        
        
        OwnerDAO dao = new OwnerDAOImpl();   
        
		String re=dao.PersonHouse(Integer.parseInt(id));
		String ordered=dao.PersonOrder(Integer.parseInt(id));
		String order=dao.PersonOrdered(Integer.parseInt(id));
		String star=dao.PersonStar(Integer.parseInt(id));
        sessionMap.put("PersonHouse", re);
        
        if (re !=""){   
            
            sessionMap.put("PersonHouse", re);   

           
        } else {   
        	sessionMap.put("PersonHouse", "<div class=\"ui center aligned container\" style=\"font-size:20px;color:#666666 ;margin-top:20px \">您还没有上传房源</div>");   
        }   
        if ( ordered !=""){   
            
            sessionMap.put("PersonOrder",  ordered);   

           
        } else {   
        	sessionMap.put("PersonOrder", "<div class=\"ui center aligned container\"style=\"font-size:20px;color:#666666 ;margin-top:20px \">您还没有发起预约</div>");   
        }   
        if ( order !=""){   
            
            sessionMap.put("PersonOrdered",  order);   

           
        } else {   
        	sessionMap.put("PersonOrdered", "<div class=\"ui center aligned container\" style=\"font-size:20px;color:#666666 ;margin-top:20px  \">还没有人预约您</div>");   
        } 
        if ( star !=""){   
            
            sessionMap.put("PersonStar",  star);   

           
        } else {   
        	sessionMap.put("PersonStar", "<div class=\"ui center aligned container\" style=\"font-size:20px;color:#666666 ;height:40px ;padding-top:10px\">收藏夹为空</div>");   
        } 
        
		//获得传递过来的用户编号
		int userId = Integer.parseInt(id);
		UserDAO udao = new UserDAOImpl();
		User u = udao.queryUserByUid(userId);
		//保留在会话中
		session.setAttribute("modify_User", u);
		
		 session.setAttribute("user_id", u.getUserId());
	     session.setAttribute("user_name", u.getUserName());   
	        session.setAttribute("user_nickname", u.getUserNickName());  
	        session.setAttribute("user", u);  
	        session.setAttribute("usergender", ""+u.getGender()); 
		    session.setAttribute("userphone", u.getPhone());
		    session.setAttribute("userwechat", u.getWechat());
		    session.setAttribute("useravatar", u.getUserAvatar());
		    session.setAttribute("useremail", u.getEMail()); 
		return "success";
        
    }
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}





    
}  

