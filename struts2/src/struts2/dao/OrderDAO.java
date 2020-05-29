package struts2.dao;


public interface OrderDAO {
	public void CancelOrder(int  orderid) throws Exception;

	public void SetOrder(int type, int orderid) throws Exception;
}
