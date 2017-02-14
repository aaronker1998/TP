import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket clientSocket;
		ObjectOutputStream out;
		ObjectInputStream in;
		try {
			
			clientSocket = new Socket("localhost", 3456);
			out = new ObjectOutputStream(clientSocket.getOutputStream());
			String u = JOptionPane.showInputDialog("URL angeben!");
			out.writeObject(u);
			out.flush();
			in = new ObjectInputStream(clientSocket.getInputStream());
			
			FileOutputStream outFile = new FileOutputStream("H:\\testNEU.html");
			
			byte[] bytes = new byte[16*1024];
	        int count;
	        while ((count = in.read(bytes)) > 0) {
	            outFile.write(bytes, 0, count);
	        }

			outFile.close();
			in.close();
			out.close();
			
			clientSocket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

