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


public class Hosts implements Runnable {
	Socket connection;
	ObjectInputStream in=null;
	ObjectOutputStream out=null;
	public String ur;
	public Hosts(Socket connection){
		try {
			in = new ObjectInputStream(connection.getInputStream());
			out = new ObjectOutputStream(connection.getOutputStream());	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.connection = connection;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{

			ur = (String) in.readObject();
			download();
			File f=new File("H:\\servus.html");
			FileInputStream fileIn = new FileInputStream(f);
			
			int count;
			byte[] bytes = new byte[16 * 1024];
	        while ((count = fileIn.read(bytes)) > 0) {
	            out.write(bytes, 0, count);
	            out.flush();
	        }
	        System.out.println("File an Client gesendet!");
			
	        fileIn.close();
			in.close();
			out.close();
			connection.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void download() throws IOException{
		URL u1;
		try {
			u1 = new URL(ur);
			InputStream in1 = new BufferedInputStream(u1.openStream());
			OutputStream out1 = new BufferedOutputStream(new FileOutputStream("H:\\servus.html"));
			int readbyte = in1.read();

			while(readbyte>=0){
				out1.write(readbyte);
				readbyte = in1.read();
			}
			System.out.println("Seite heruntergeladen!");
			in1.close();
			out1.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
