import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

//CLIENT
public class Main {
	public static void main(String[] args){
		Socket clientSocket;
		ObjectOutputStream out;
		ObjectInputStream in;
		
	
		
		
		try {
			clientSocket = new Socket("localhost", 3000);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new ObjectInputStream(clientSocket.getInputStream());
			String username = JOptionPane.showInputDialog("Username:");
			String password = JOptionPane.showInputDialog("Passwort");
			Anmeldung an = new Anmeldung(username,password);
			out.writeObject(an);
			out.flush();
			String za1 = JOptionPane.showInputDialog("Zahl1:");
			String zeichen = JOptionPane.showInputDialog("+,-,*,/?");
			String za2 = JOptionPane.showInputDialog("Zahl2:");
			int z1= Integer.parseInt(za1);
			int z2 = Integer.parseInt(za2);
			Rechnung rech = new Rechnung(z1,zeichen,z2);
			out.writeObject(rech);
			out.flush();
			System.out.println(z1+zeichen+z2+"="+in.readObject());
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
