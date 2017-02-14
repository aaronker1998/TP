import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//SERVER
public class Main {
	public static void main(String[] args){
		ServerSocket serverSocket;
		Socket connection= null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		float erg= 0;
		String user = "admin";
		String pass = "123456789";
		boolean ch;
		try {
			serverSocket= new ServerSocket(2000);
			System.out.println("Server erstellt");
			connection = serverSocket.accept();
			System.out.println("Verbindung aufgebaut");
			in = new ObjectInputStream(connection.getInputStream());
			out = new ObjectOutputStream(connection.getOutputStream());
				
			Anmeldung an = (Anmeldung) in.readObject();
				ch=an.check();
				if(ch==true){
					Rechnung rech = (Rechnung) in.readObject();
					erg=rech.berechnen();
					out.writeObject(erg);
					out.flush();
					in.close();
					out.close();
				}else
				{
				out.writeObject("Login failed!");
				out.flush();
				in.close();
				out.close();
			}

			connection.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
