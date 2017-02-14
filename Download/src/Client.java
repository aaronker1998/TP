import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;

import javax.swing.JOptionPane;


public class Client {
	public static void main(String[] args) throws ClassNotFoundException{
		Socket clientSocket;
		ObjectOutputStream out;
		ObjectInputStream in;
		String message = "Hallo";
	
		try {
			clientSocket = new Socket("localhost", 3000);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			//String url = JOptionPane.showInputDialog("Passwort");
			out.writeObject(message);
			out.flush();
			int read = (int) in.readObject();
			System.out.println(read);
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
