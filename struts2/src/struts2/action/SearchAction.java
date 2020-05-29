


package struts2.action;

import java.util.Map;   

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import struts2.dao.SearchDAO;

import struts2.dao.impl.SearchDAOImpl;

  
import com.opensymphony.xwork2.ActionContext;   
import com.opensymphony.xwork2.ActionSupport;
  
public class SearchAction extends ActionSupport{   
  
	private static final long serialVersionUID = 1L;
	
	private static String province;
	private static String search;
	public  int pageNow = 1;
	ActionContext actionContext = ActionContext.getContext(); 
    Map<String, Object> session = actionContext.getSession(); 
   // private static final long serialVersionUID = 1L;   
    
    public String execute() throws Exception {   
    	if(pageNow==0){this.addActionError("已是第一页");pageNow++;return "success";}
    	HttpServletRequest request = ServletActionContext.getRequest();
        if(request.getParameter("province")!=null)
    	province = request.getParameter("province");
        if(request.getParameter("search")!=null)
        search=request.getParameter("search");
        System.out.println("province in action"+province);
        System.out.println("search in action"+search);
        System.out.println("pagenow++++++++++++++++"+pageNow);
    	SearchDAO dao = new SearchDAOImpl();   
    	session.put("tag", "false");
		String re = dao.Search(Integer.parseInt(province),search ,pageNow )  ; 
		
		if (re !=""){   
	            
	            session.put("searchresult", re);   

	           
	        } else if(pageNow == 1) {   
	        	session.put("searchresult", "<div>搜索结果为空</div>");   
	        }   else{
	        	this.addActionError("已是最后一页！");
	        	pageNow--;return "success";
	        	
	        }
	    

		return "success";
            
    
    }
      
  
   



	public void setprovince(String province) {
		this.province = province;
	}



	public static String getprovince() {
		return province;
	}



	public void setSearch(String search) {
		this.search = search;
	}



	public static String getSearch() {
		return search;
	}





    
}  

