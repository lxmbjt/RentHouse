package modify.action;

import modify.entity.House;
import modify.service.HouseDAO;
import modify.service.impl.HouseDAOImpl;

import com.opensymphony.xwork2.ModelDriven;


public class HouseAction extends SuperAction implements ModelDriven<House> {

	private static final long serialVersionUID = 1L;
	private House house = new House();
	
	//修改房屋资料
	public String modify() {

		//获得传递过来的房屋编号
		int houseId = Integer.parseInt(request.getParameter("houseId"));
		HouseDAO udao = new HouseDAOImpl();
		House u = udao.queryHouseByUid(houseId);
		//保留在会话中
		session.setAttribute("modify_House", u);
		return "modify_success";
	}
	
	//保存修改后的房屋资料
	public String save(){
		House h  = (House)session.getAttribute("modify_House");
		h.setHouseTitle(request.getParameter("houseTitle"));
		h.setProvince(Integer.parseInt(request.getParameter("province")));
		h.setHouseTitle(request.getParameter("city"));

		return "save_success";
	}
	
	//用一个函数把有无转化为Boolean，让代码优雅一点~
	private boolean getBoolean(String org) {
		if(org.equals("有"))
			return true;
		else
			return false;
	}
	
	public House getModel() {
		// TODO Auto-generated method stub
		if(null == house){
			return house = new House();
		}
		return house;
	}
	

}
