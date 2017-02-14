import java.io.Serializable;


public class Website extends Message implements Serializable {
	String url;
	byte [] bytearr = new byte[16 * 1024];
}
