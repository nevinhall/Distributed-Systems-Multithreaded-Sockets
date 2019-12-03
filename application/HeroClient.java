package application;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HeroClient {



	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException  {
		ArrayList<Object> recievedreadyVillains = null;
		String host = "localhost";
		Socket socket = null;
		try {
			// Establish connection with the server
			socket = new Socket(host, 8003);

			ObjectInputStream recievedVillains = new ObjectInputStream(socket.getInputStream());


			recievedreadyVillains = (ArrayList<Object>) recievedVillains.readObject();
			System.out.println(recievedreadyVillains.get(0));
			//recievedVillains.close();
			//socket.close();

		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		//		Socket socketThreads = null;
		//		
		//		
		//		socketThreads = new Socket(host, 7006);
		 ReactID idVillains = new ReactID();
		for(int i = 0; i < recievedreadyVillains.size(); i++ ){
			Object villain = recievedreadyVillains.get(i);
			SuperHero hero = idVillains.id(villain);
			ObjectOutputStream sendHero = new ObjectOutputStream(socket.getOutputStream()); 
			Thread.sleep(1000);
			sendHero.writeObject(hero);
			System.out.println("Sent Hero");

			//Object villain = recievedreadyVillains.get(i);
			//sendHeroesThread t = new sendHeroesThread(socket,villain);
			//			t.start();
			//			t.sleep(10000);

		}

		socket.close();







	}


}


