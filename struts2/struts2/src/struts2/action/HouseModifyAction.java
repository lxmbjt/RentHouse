package struts2.action;


import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;



  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class HouseModifyAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	private String houseid;
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
        houseid = request.getParameter("houseid");
        
        System.out.println("title in action"+houseid);
        
    	
  
		String re = houseid;
		
		if (re !=""){   
	            
	            session.put("houseresult", re);   

	           
	        } else {   
	        	session.put("houseresult", "<div>ËÑË÷½á¹ûÎª¿Õ</div>");   
	        }   
	    

		return "success";
            
    
    }
      
  
   









	





    
}  
