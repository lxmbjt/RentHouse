package modify.entity;
 
public class Favorite {
	
	private int favoriteId;
	private User user;
	private House house;
	
	public Favorite() {
		
	}

	public Favorite(int favoriteId) {
		//super();
		this.favoriteId = favoriteId;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
}
