import java.io.Serializable;


public class Rechnung extends Message implements Serializable {
	int z1;
	String zeichen;
	int z2;
	float erg;
	
	public Rechnung(int z1, String zeichen,int z2){
		this.z1=z1;
		this.zeichen=zeichen;
		this.z2=z2;
	}
	public float berechnen(){
		switch(zeichen){
		case "+": erg=z1+z2; return erg;
		case "-": erg=z1-z2; return erg;
		case "*": erg=z1*z2; return erg;
		case "/": erg=z1/z2; return erg;
		}
		return 0;
	}
}
