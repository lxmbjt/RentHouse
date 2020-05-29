package struts2.dao;

import struts2.vo.User;

public interface OwnerDAO {
	public User Owner(int id) throws Exception;
	public String OwnerHouse(int ownerid) throws Exception;
	public String PersonHouse(int ownerid) throws Exception; 
	public String PersonOrder(int ownerid) throws Exception; 
	public String PersonOrdered(int ownerid) throws Exception; 
	public String PersonStar(int ownerid) throws Exception; 
	public String PersonStarList(int ownerid) throws Exception; 
	public void  deletehouse(int id) throws Exception;
	public void offhouse(int id)throws Exception;
	public void uphouse(int id) throws Exception;
	User queryById(int userId);
}
