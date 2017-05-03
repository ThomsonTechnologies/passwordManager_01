package passwordManger;


public class Professional extends PasswordAccount implements Favourite{
	private boolean favourite;
	
	public Professional(String title, String userName, 
			String password, String description, String category) {
		super(title, userName, password, description, category);
	}
	
	@Override
	public void setFavourite(boolean status) {
		this.favourite = status;
	}

	@Override
	public boolean getFavourite() {
		return this.favourite;
	}


}