package modify.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//·¿ÎÝÀà
public class House{
	
	private int houseId;
	private String houseTitle;
	private int province;
	private String city;
	private String address;
	private int roomNumber;
	private int rentType;
	private int charge;
	private int roomType;
	private int towards;
	private Boolean elevator;
	private int storey;
	private Boolean bed;
	private Boolean network;
	private Boolean airondition;
	private Boolean balcony;
	private Boolean refrigerator;
	private Boolean toilet;
	private Boolean kitchen;
	private Boolean bath;
	private Boolean heating;
	private Date releaseTime;
	private String comment;
	private int chargeType;
	private Boolean livingroom;
	private User user;
	private Set favorites = new HashSet();
	private Set picses = new HashSet();
	
	public House() {
		
	}

	public House(int houseId, String houseTitle, int province, String city, String address,
			int roomNumber, int rentType, int charge, int roomType,
			int towards, Boolean elevator, int storey, Boolean bed,
			Boolean network, Boolean airondition, Boolean balcony,
			Boolean refrigerator, Boolean toilet, Boolean kitchen,
			Boolean bath, Boolean heating, Date releaseTime, String comment,
			int chargeType, Boolean livingroom) {
		//super();
		this.houseId = houseId;
		this.houseTitle = houseTitle;
		this.province = province;
		this.city = city;
		this.address = address;
		this.roomNumber = roomNumber;
		this.rentType = rentType;
		this.charge = charge;
		this.roomType = roomType;
		this.towards = towards;
		this.elevator = elevator;
		this.storey = storey;
		this.bed = bed;
		this.network = network;
		this.airondition = airondition;
		this.balcony = balcony;
		this.refrigerator = refrigerator;
		this.toilet = toilet;
		this.kitchen = kitchen;
		this.bath = bath;
		this.heating = heating;
		this.releaseTime = releaseTime;
		this.comment = comment;
		this.chargeType = chargeType;
		this.livingroom = livingroom;
	}

	public int getHouseId() {
		return houseId;
	}
	
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	
	public void setHouseTitle(String houseTitle) {
		this.houseTitle = houseTitle;
	}

	public String getHouseTitle() {
		return houseTitle;
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
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getRentType() {
		return rentType;
	}
	
	public void setRentType(int rentType) {
		this.rentType = rentType;
	}
	
	public int getCharge() {
		return charge;
	}
	
	public void setCharge(int charge) {
		this.charge = charge;
	}
	
	public int getRoomType() {
		return roomType;
	}
	
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	
	public int getTowards() {
		return towards;
	}
	
	public void setTowards(int towards) {
		this.towards = towards;
	}
	
	public Boolean getElevator() {
		return elevator;
	}
	
	public void setElevator(Boolean elevator) {
		this.elevator = elevator;
	}
	
	public int getStorey() {
		return storey;
	}
	
	public void setStorey(int storey) {
		this.storey = storey;
	}
	
	public Boolean getBed() {
		return bed;
	}
	
	public void setBed(Boolean bed) {
		this.bed = bed;
	}
	
	public Boolean getNetwork() {
		return network;
	}
	
	public void setNetwork(Boolean network) {
		this.network = network;
	}
	
	public Boolean getAirondition() {
		return airondition;
	}
	
	public void setAirondition(Boolean airondition) {
		this.airondition = airondition;
	}
	
	public Boolean getBalcony() {
		return balcony;
	}
	
	public void setBalcony(Boolean balcony) {
		this.balcony = balcony;
	}
	
	public Boolean getRefrigerator() {
		return refrigerator;
	}
	
	public void setRefrigerator(Boolean refrigerator) {
		this.refrigerator = refrigerator;
	}
	
	public Boolean getToilet() {
		return toilet;
	}
	
	public void setToilet(Boolean toilet) {
		this.toilet = toilet;
	}
	
	public Boolean getKitchen() {
		return kitchen;
	}
	
	public void setKitchen(Boolean kitchen) {
		this.kitchen = kitchen;
	}
	
	public Boolean getBath() {
		return bath;
	}
	
	public void setBath(Boolean bath) {
		this.bath = bath;
	}
	
	public Boolean getHeating() {
		return heating;
	}
	
	public void setHeating(Boolean heating) {
		this.heating = heating;
	}
	
	public Date getReleaseTime() {
		return releaseTime;
	}
	
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getChargeType() {
		return chargeType;
	}
	
	public void setChargeType(int chargeType) {
		this.chargeType = chargeType;
	}
	
	public Boolean getLivingroom() {
		return livingroom;
	}
	
	public void setLivingroom(Boolean livingroom) {
		this.livingroom = livingroom;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Set getFavorites() {
		return favorites;
	}

	public void setFavorites(Set favorites) {
		this.favorites = favorites;
	}

	public Set getPicses() {
		return picses;
	}

	public void setPicses(Set picses) {
		this.picses = picses;
	}
	
}