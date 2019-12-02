import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HeroClient {

<<<<<<< Updated upstream
	public static void main(String[] args) {
		  String host = "localhost";
		 try {
		        // Establish connection with the server
		        Socket socket = new Socket(host, 8007);

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
=======
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
>>>>>>> Stashed changes

	}

}
