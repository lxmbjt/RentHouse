package modify.service;

import modify.entity.House;

public interface HouseDAO {
	
	//����id��ѯ��������
	public House queryHouseByUid(int houseId);
	
	//�޸ķ�������
	public boolean updateHouse(House u);

}
