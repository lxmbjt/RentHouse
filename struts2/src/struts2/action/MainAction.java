


package struts2.action;

import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import struts2.dao.MainDAO;
import struts2.dao.SearchDAO;

import struts2.dao.impl.MainDAOImpl;
import struts2.dao.impl.SearchDAOImpl;

  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class MainAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	

	
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    
    public String execute() throws Exception {   
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
      
       
     
    	MainDAO dao = new MainDAOImpl();   
    	
		String re = dao.show9()  ; 
	
	            
	            session.put("show9", re);   

	           
	        
	    

		return "success";
            
    }
    }
      
  
   



