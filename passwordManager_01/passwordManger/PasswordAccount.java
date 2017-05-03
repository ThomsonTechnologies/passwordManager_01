package passwordManger;

import java.io.Serializable;

public class PasswordAccount extends PasswordManager implements Serializable{
	
	private String title;
	private String userName;
	private String password;
	String description;
	private String category;
	
	public PasswordAccount(String title, String userName, 
			String password, String description, String category) {
		//super();
		this.title = title;
		this.userName = userName;
		this.password = password;
		this.description = description;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
		
}
