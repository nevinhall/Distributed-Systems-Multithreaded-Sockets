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
			socket = new Socket(host, 7006);

			ObjectInputStream recievedVillains = new ObjectInputStream(socket.getInputStream());

			recievedreadyVillains = (ArrayList<Object>) recievedVillains.readObject();
			System.out.println(recievedreadyVillains.get(0));
			//socket.close();

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

//		Socket socketThreads = null;
//		
//		
//		socketThreads = new Socket(host, 7006);
		
		for(int i = 0; i < recievedreadyVillains.size(); i++ ){
			Object villain = recievedreadyVillains.get(i);
			new sendHeroesThread(socket,villain).start();
			
		}
		


			



	}


}


