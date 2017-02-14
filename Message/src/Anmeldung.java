import java.io.Serializable;


public class Anmeldung extends Message implements Serializable {
	String username;
	String password;
	
	String user = "admin";
	String pass = "admin";
	
	public Anmeldung(String username, String password){
		this.username = username;
		this.password = password;
	}
	public boolean check(){
		if(username.equals(user)&&password.equals(pass)){
			return true;
		}
		return false;
	}
}
