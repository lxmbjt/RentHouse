package struts2.action;

import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import struts2.dao.OwnerDAO;
import struts2.dao.impl.OwnerDAOImpl;
import struts2.vo.User;
  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class HouseDeleteAction extends ActionSupport{   
  
   
	private static final long serialVersionUID = 1L;
	
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
  
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        String id= request.getParameter("deletehouse");
        System.out.println("delete id is"+id);
        OwnerDAO dao = new OwnerDAOImpl();   
        dao.deletehouse(Integer.parseInt(id));
		
        
      
		return "success";
        
      
    }
    

	


    
}  

