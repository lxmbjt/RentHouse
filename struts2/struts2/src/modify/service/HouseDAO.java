package modify.service;

import modify.entity.House;

public interface HouseDAO {
	
	//根据id查询房屋资料
	public House queryHouseByUid(int houseId);
	
	//修改房屋资料
	public boolean updateHouse(House u);

}
