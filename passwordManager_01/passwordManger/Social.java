package passwordManger;


public class Social extends PasswordAccount implements Favourite{
	private boolean favourite;
	
	public Social(String title, String userName, 
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
