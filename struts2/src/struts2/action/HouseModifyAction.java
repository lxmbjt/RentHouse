package struts2.action;


import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import modify.action.SuperAction;
import modify.entity.House;
import modify.service.HouseDAO;
import modify.service.impl.HouseDAOImpl;

import org.apache.struts2.ServletActionContext;



  
import com.opensymphony.xwork2.ActionContext;   

  
public class HouseModifyAction extends SuperAction{   
  
	private static final long serialVersionUID = 1L;
	
	private String houseid;
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> sessionMap = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    
    public String execute() throws Exception {   
    	HttpServletRequest request = ServletActionContext.getRequest();
        houseid = request.getParameter("houseid");
        
        System.out.println("title in action"+houseid);
        
    	
  
		String re = houseid;
		
		if (re !=""){   
	            
	            sessionMap.put("houseresult", re);   

	           
	        } else {   
	        	sessionMap.put("houseresult", "<div>搜索结果为空</div>");   
	        }   
		
		HouseDAO udao = new HouseDAOImpl();
		House u = udao.queryHouseByUid(Integer.parseInt(houseid));
		//保留在会话中
		session.setAttribute("modify_House", u);

		return "success";
    
    }
      
  
   









	





    
}  
