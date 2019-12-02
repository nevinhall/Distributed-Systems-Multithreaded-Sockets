package application;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HeroClient {



	public static void main(String[] args) throws ClassNotFoundException, IOException  {
		ArrayList<Object> recievedreadyVillains = null;
		String host = "localhost";
		Socket socket = null;
		try {
			// Establish connection with the server
			socket = new Socket(host, 7001);
			
			ObjectInputStream recievedVillains = new ObjectInputStream(socket.getInputStream());
			 
			recievedreadyVillains = (ArrayList<Object>) recievedVillains.readObject();
			System.out.println(recievedreadyVillains.get(0));

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		//		


		//		
		//		
		//		socket.close();



	}


}


