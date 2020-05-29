package modify.action;

import modify.entity.House;
import modify.service.impl.HouseDAOImpl;

import com.opensymphony.xwork2.ModelDriven;


public class HouseAction extends SuperAction implements ModelDriven<House> {

	private static final long serialVersionUID = 1L;
	private House house = new House();
	
	//�����޸ĺ�ķ�������
	public String save(){
		House h  = (House)session.getAttribute("modify_House");
		h.setHouseTitle(request.getParameter("houseTitle"));
		h.setProvince(Integer.parseInt(request.getParameter("province")));
		h.setCity(request.getParameter("city"));
		
		HouseDAOImpl hdao = new HouseDAOImpl();
		hdao.updateHouse(h);
		return "save_success";
	}
	
	//��һ������������ת��ΪBoolean���ô�������һ��~
	private boolean getBoolean(String org) {
		if(org.equals("��"))
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
