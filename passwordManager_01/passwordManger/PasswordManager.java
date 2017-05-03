package passwordManger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class PasswordManager implements Serializable{
	//private PasswordAccount passwordAccount;
	private static ArrayList<PasswordAccount> passwordAccounts = new ArrayList<PasswordAccount>();
	private ArrayList<Favourite> favouriteAccounts = new ArrayList<Favourite>();
	
	public PasswordManager() {
		
	}

	public static ArrayList<PasswordAccount> getAccounts() {
		return passwordAccounts;
	}

	public void addAccount(PasswordAccount account){
		passwordAccounts.add(account);
	}
	
	public ArrayList<Favourite> getFavourites() {
		return favouriteAccounts;
	}

	public void addFavourite(Favourite favourite){
		favouriteAccounts.add(favourite);
	} 
	
	public void saveToFile(ArrayList<PasswordAccount> list){
		
	}
	
	public void saveAccount(PasswordAccount account)throws Exception{

		File file = new File("accounts");
		if(!file.exists()){
			 ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream(file));
 	        os1.writeObject(account);
 	        os1.close();
		}else{
    		ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("accounts", true)) {
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };

            os2.writeObject(account);
            os2.close();
    	}

	}
}
