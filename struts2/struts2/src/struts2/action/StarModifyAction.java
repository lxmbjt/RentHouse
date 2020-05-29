package struts2.action;


import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

//import javax.servlet.http.HttpServletRequest;

//import org.apache.struts2.ServletActionContext;

import struts2.dao.OwnerDAO;
import struts2.dao.StarDAO;
import struts2.dao.impl.OwnerDAOImpl;
import struts2.dao.impl.StarDAOImpl;
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class StarModifyAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	OwnerDAO dao = new OwnerDAOImpl();
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    StarDAO dao2 = new StarDAOImpl();
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String deletestar = request.getParameter("deletestar");
    	String id= session.get("user_id").toString();
    	
        System.out.println("id in staraction"+id);
		
        System.out.println("deletestar"+deletestar);
        if(deletestar!=null){
        	
        	dao2.Deletestar(Integer.parseInt(deletestar));
        	
        }
        String re= dao.PersonStarList(Integer.parseInt(id))  ;
        //System.out.println("re"+re);
        if (re !=""){   
            
            session.put("starlist", re);   

           
        } else {   
        	session.put("starlist", "<div>该房主没有上传房源</div>");   
        }   
	           
	       
	    

		return "success";
            
    
    }
      
  
   









	





    
}  
