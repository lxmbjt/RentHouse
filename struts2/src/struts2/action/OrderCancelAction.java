package struts2.action;


import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

//import javax.servlet.http.HttpServletRequest;

//import org.apache.struts2.ServletActionContext;

import struts2.dao.OrderDAO;
import struts2.dao.OwnerDAO;
import struts2.dao.StarDAO;
import struts2.dao.impl.OrderDAOImpl;
import struts2.dao.impl.OwnerDAOImpl;
import struts2.dao.impl.StarDAOImpl;
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class OrderCancelAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	OwnerDAO dao = new OwnerDAOImpl();
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    StarDAO dao2 = new StarDAOImpl();
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String cancelorder = request.getParameter("cancelorder");
    	
        System.out.println("cancelorder" +cancelorder);
	       
        OrderDAO dao = new OrderDAOImpl();
        dao.CancelOrder(Integer.parseInt(cancelorder));
        String id= session.get("user_id").toString();
        OwnerDAO dao1 = new OwnerDAOImpl();  
        String order=dao1.PersonOrder(Integer.parseInt(id));
        if ( order !=""){   
            
            session.put("PersonOrder",  order);   

           
        } else {   
        	session.put("PersonOrder", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">还没有人预约您</div>");   
        } 
		return "success";
            
    
    }
      
  
   









	





    
}  
