


package struts2.action;

import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import struts2.dao.OwnerDAO;

import struts2.dao.impl.OwnerDAOImpl;

import struts2.vo.User;

  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class OwnerAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	private String ownerid;
	
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
    	ownerid = request.getParameter("ownerid");
      
        System.out.println("ownerid in action"+ownerid);
    	OwnerDAO dao = new OwnerDAOImpl();   
  
		User owner= dao.Owner(Integer.parseInt(ownerid))  ; 
		String re=dao.OwnerHouse(Integer.parseInt(ownerid));
		
	            
	    session.put("ownername", owner.getUser_name());   
	    session.put("ownergender", ""+owner.getGender()); 
	    session.put("ownerphone", owner.getPhone());
	    session.put("ownerwechat", owner.getWechat());
	    session.put("owneravatar", owner.getUser_avatar());
	    session.put("owneremail", owner.getE_mail());
	           
	     
	    if (re !=""){   
            
            session.put("ownerhouse", re);   

           
        } else {   
        	session.put("ownerhouse", "<div>该房主没有上传房源</div>");   
        }   
		return "success";
            
    
    }
      
  
   



	





	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}






	public String getOwnerid() {
		return ownerid;
	}





    
}  

