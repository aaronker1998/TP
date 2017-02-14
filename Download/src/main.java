import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;


public class main {
	public static void main(String[] args){
		ServerSocket serverSocket;
		Socket connection= null;
		ObjectInputStream in=null;
		ObjectOutputStream out=null;
		InputStream is;
		
		try {
			serverSocket= new ServerSocket(3000);
			System.out.println("Server erstellt");
			connection = serverSocket.accept();
			System.out.println("Verbindung aufgebaut");
			in = new ObjectInputStream(connection.getInputStream());
			out = new ObjectOutputStream(connection.getOutputStream());
			/*URL message = new URL((String) in.readObject());
			is = message.openStream();*/
			download();
			connection.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void download() throws IOException{
		URL u1;
		try {
			u1 = new URL("http://linuxserver/~stkeraar/test.html");
			InputStream in1 = new BufferedInputStream(u1.openStream());
			OutputStream out1 = new BufferedOutputStream(new FileOutputStream("H:\\servus.html"));
			int readbyte = in1.read();

			while(readbyte>=0){
				out1.write(readbyte);
				readbyte = in1.read();
			}
			System.out.println("Datei heruntergeladen!");
			out1.flush();
			in1.close();
			out1.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
