package passwordManger;

public class Personal extends PasswordAccount implements Favourite{
	private boolean favourite = false;
		
	public Personal(String title, String userName, 
			String password, String description, String category) {
		super(title, userName, password, description, category);
	}
	
	@Override
	public void setFavourite(boolean status) {
		this.favourite = status;
	}

	@Override
	public boolean getFavourite() {
		return favourite;
	}

}
