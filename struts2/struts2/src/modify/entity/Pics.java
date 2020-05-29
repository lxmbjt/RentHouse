package modify.entity;
 
public class Pics {
	
	private int picsId;
	private String pic;
	private House house;
	
	public Pics() {
		
	}

	public Pics(int picsId, String pic) {
		//super();
		this.picsId = picsId;
		this.pic = pic;
	}

	public int getPicsId() {
		return picsId;
	}

	public void setPicsId(int picsId) {
		this.picsId = picsId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
}
