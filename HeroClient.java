import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Observable;

public class HeroClient {
	static Socket socket = null;

	public static void main(String[] args) throws ClassNotFoundException  {
		String host = "localhost";
		try {
			// Establish connection with the server
			socket = new Socket(host, 7003);

			// Create an output stream to the server
//			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
//			toServer.flush();
//			toServer.close();

			//Allows test value 
//			DataInputStream fromServerBoolean = new DataInputStream(socket.getInputStream());
//			Object test =  fromServerBoolean.readBoolean();
//			System.out.println("value is" + test.toString());
//			fromServerBoolean.close();
			

			//Create I/O to allow client to recieve villian objects
			ObjectInputStream villansFromServer = new ObjectInputStream(socket.getInputStream());
			Object recievedVillain = villansFromServer.readObject();


//			Object object = inputFromClient.readBoolean();
//			System.out.println("sent from server " + object);
//			toServer.writeBoolean(true);
//			toServer.flush();


			//Recieve and deserialise objects from server
				File destination = new File ("D://college 2019//College third year//semester one//Disturbted systems//common//saved-the-world-again//saved"  + 1 + ".ser");
				FileOutputStream fileOut =	new FileOutputStream(destination);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(recievedVillain);
				out.close();
				fileOut.close();


				//  
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		
					 try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}

	}
