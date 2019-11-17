import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Observable;

public class HeroClient {

	public static void main(String[] args)  {
		  String host = "localhost";
		 try {
		        // Establish connection with the server
		        Socket socket = new Socket(host, 8009);

		        // Create an output stream to the server
		        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
		        
		        Object object = inputFromClient.readBoolean();
		        System.out.println("sent from server " + object);

		        toServer.writeBoolean(true);
		        
		        
		        
		      }
		      catch (IOException ex) {
		        ex.printStackTrace();
		      }
		// TODO Auto-generated method stub

	}

}
