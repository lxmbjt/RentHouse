package modify.action;

import modify.entity.House;
import modify.service.impl.HouseDAOImpl;

import com.opensymphony.xwork2.ModelDriven;


public class HouseAction extends SuperAction implements ModelDriven<House> {

	private static final long serialVersionUID = 1L;
	private House house = new House();
	
	//保存修改后的房屋资料
	public String save(){
		House h  = (House)session.getAttribute("modify_House");
		h.setHouseTitle(request.getParameter("houseTitle"));
		h.setProvince(Integer.parseInt(request.getParameter("province")));
		h.setCity(request.getParameter("city"));
		
		HouseDAOImpl hdao = new HouseDAOImpl();
		hdao.updateHouse(h);
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
