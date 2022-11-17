
public class User {
	int userID;
	String fname;
	String lname;
	String email;
	public User(int userID, String fname, String lname, String email) {
		super();
		this.userID = userID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
