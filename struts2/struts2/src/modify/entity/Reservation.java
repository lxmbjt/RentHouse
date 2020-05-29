package modify.entity;

import java.sql.Time;
import java.util.Date;
 
public class Reservation {

	private int reverseId;
	private Date date;
	private Time time;
	private String position;
	private String message;
	private User userByFUserIdOwner;
	private User userByFUserIdRent;
	
	public Reservation() {
		
	}

	public Reservation(int reverseId, Date date, Time time, String position,
			String message) {
		//super();
		this.reverseId = reverseId;
		this.date = date;
		this.time = time;
		this.position = position;
		this.message = message;
	}

	public int getReverseId() {
		return reverseId;
	}

	public void setReverseId(int reverseId) {
		this.reverseId = reverseId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUserByFUserIdOwner() {
		return userByFUserIdOwner;
	}

	public void setUserByFUserIdOwner(User userByFUserIdOwner) {
		this.userByFUserIdOwner = userByFUserIdOwner;
	}

	public User getUserByFUserIdRent() {
		return userByFUserIdRent;
	}

	public void setUserByFUserIdRent(User userByFUserIdRent) {
		this.userByFUserIdRent = userByFUserIdRent;
	}
	
}
