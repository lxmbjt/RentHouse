package modify.action;

import modify.entity.House;
import modify.service.HouseDAO;
import modify.service.impl.HouseDAOImpl;

import com.opensymphony.xwork2.ModelDriven;


public class HouseAction extends SuperAction implements ModelDriven<House> {

	private static final long serialVersionUID = 1L;
	private House house = new House();
	
	//�޸ķ�������
	public String modify() {

		//��ô��ݹ����ķ��ݱ��
		int houseId = Integer.parseInt(request.getParameter("houseId"));
		HouseDAO udao = new HouseDAOImpl();
		House u = udao.queryHouseByUid(houseId);
		//�����ڻỰ��
		session.setAttribute("modify_House", u);
		return "modify_success";
	}
	
	//�����޸ĺ�ķ�������
	public String save(){
		House h  = (House)session.getAttribute("modify_House");
		h.setHouseTitle(request.getParameter("houseTitle"));
		h.setProvince(Integer.parseInt(request.getParameter("province")));
		h.setHouseTitle(request.getParameter("city"));

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
