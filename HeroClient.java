import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HeroClient {


	public static void main(String[] args) throws ClassNotFoundException  {
		String host = "localhost";
		try {
			// Establish connection with the server
			socket = new Socket(host, 8001);


			//Allows test value 
			//			DataInputStream fromServerBoolean = new DataInputStream(socket.getInputStream());
			//			Object test =  fromServerBoolean.readBoolean();
			//			System.out.println("value is" + test.toString());
			//			fromServerBoolean.close();



			while (true) {
				// Establish connection with the server
				new ServerHandler(socket).start();;
			}



		}
		catch (IOException ex) {
			ex.printStackTrace();
		}


	}


}


