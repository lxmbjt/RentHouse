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
  
public class SetOrderAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	OwnerDAO dao = new OwnerDAOImpl();
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    StarDAO dao2 = new StarDAOImpl();
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String settype = request.getParameter("settype");//1为接收2为拒绝
    	String setorder = request.getParameter("setorder");//处理的orderid
        System.out.println("setorder"+settype+setorder);
	       
        OrderDAO dao = new OrderDAOImpl();
        dao.SetOrder(Integer.parseInt(settype),Integer.parseInt(setorder));
        String id= session.get("user_id").toString();
        OwnerDAO dao1 = new OwnerDAOImpl();  
        String order=dao1.PersonOrdered(Integer.parseInt(id));
        if ( order !=""){   
            
            session.put("PersonOrdered",  order);   

           
        } else {   
        	session.put("PersonOrdered", "<div class=\"ui center aligned container\" style=\"font-size:30px;color:#00B5AD ;margin-top:50px \">还没有人预约您</div>");   
        } 
		return "success";
            
    
    }
      
  
   









	





    
}  
