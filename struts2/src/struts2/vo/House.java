package struts2.vo;

import java.sql.Date;

public class House {
	private int house_id;//����
	private int f_owner_id;//����id
	private String housetitle;//���ݱ���
	private int province;//ʡ��
	private String city;//������
	private String address;//��ϸ��ַ
	private int room_number;//�������
	private int rent_type;//���ⷽʽ�����⡢���⡢���ޡ�
	private int charge;//���
	private int room_type;//�������ͣ���ͨסլ����Ԣ���ĺ�Ժ����ס���á�ƽ���������ȡ�
	private int towards;//���ݳ��򣬳��ϡ�����������������
	private int storey;//����¥��
	private int area;//�������
	//*********����Ϊ��������********//
	private int elevator;
	private int bed;//�ṩ��
	private int network;//����
	private int airondition;//�յ�
	private int balcony;//��̨
	private int refrigerator;//����
	private int toilet;//����
	private int kitchen;
	private int bath;//ԡ��
	private int heating;//��ů
	private int television;//����
	private int washing_machine;//ϴ�»�	
	private int water_heater;//��ˮ��
	private int sofa;//ɳ��
	private int livingroom;//����
	private int wardrobe;//�¹�
	private int status;//����״̬���¼����
	//*********************//
	private Date release_time;//��Ϣ�ϴ�ʱ��
	private String comment;//����������Ϣ
	private int charge_type;//���ʽ����Ѻһ������Ѻһ��һ��Ѻһ������
	private int decoration;//����װ�ޣ�1��װ�ޣ�2��װ�ޣ�3δװ��
	public int getElevator() {
		return elevator;
	}
	public void setElevator(int elevator) {
		this.elevator = elevator;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public int getF_owner_id() {
		return f_owner_id;
	}
	public void setF_owner_id(int f_owner_id) {
		this.f_owner_id = f_owner_id;
	}
	public String getHousetitle() {
		return housetitle;
	}
	public void setHousetitle(String housetitle) {
		this.housetitle = housetitle;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public int getRent_type() {
		return rent_type;
	}
	public void setRent_type(int rent_type) {
		this.rent_type = rent_type;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getRoom_type() {
		return room_type;
	}
	public void setRoom_type(int room_type) {
		this.room_type = room_type;
	}
	public int getTowards() {
		return towards;
	}
	public void setTowards(int towards) {
		this.towards = towards;
	}
	public int getStorey() {
		return storey;
	}
	public void setStorey(int storey) {
		this.storey = storey;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public int getNetwork() {
		return network;
	}
	public void setNetwork(int network) {
		this.network = network;
	}
	public int getAirondition() {
		return airondition;
	}
	public void setAirondition(int airondition) {
		this.airondition = airondition;
	}
	public int getBalcony() {
		return balcony;
	}
	public void setBalcony(int balcony) {
		this.balcony = balcony;
	}
	public int getRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(int refrigerator) {
		this.refrigerator = refrigerator;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	public int getKitchen() {
		return kitchen;
	}
	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}
	public int getBath() {
		return bath;
	}
	public void setBath(int bath) {
		this.bath = bath;
	}
	public int getHeating() {
		return heating;
	}
	public void setHeating(int heating) {
		this.heating = heating;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCharge_type() {
		return charge_type;
	}
	public void setCharge_type(int charge_type) {
		this.charge_type = charge_type;
	}
	public int getLivingroom() {
		return livingroom;
	}
	public void setLivingroom(int livingroom) {
		this.livingroom = livingroom;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getTelevision() {
		return television;
	}
	public void setTelevision(int television) {
		this.television = television;
	}
	public int getWashing_machine() {
		return washing_machine;
	}
	public void setWashing_machine(int washing_machine) {
		this.washing_machine = washing_machine;
	}
	public int getWater_heater() {
		return water_heater;
	}
	public void setWater_heater(int water_heater) {
		this.water_heater = water_heater;
	}
	public int getSofa() {
		return sofa;
	}
	public void setSofa(int sofa) {
		this.sofa = sofa;
	}
	public int getDecoration() {
		return decoration;
	}
	public void setDecoration(int decoration) {
		this.decoration = decoration;
	}
	public int getWardrobe() {
		return wardrobe;
	}
	public void setWardrobe(int wardrobe) {
		this.wardrobe = wardrobe;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
