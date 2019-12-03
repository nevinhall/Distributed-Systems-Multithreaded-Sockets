package application;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import villians.Person;

public class HeroClient {



	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException  {
		ArrayList<Object> recievedreadyVillains = null;
		String host = "localhost";
		Socket socket = null;
//		try {
//			// Establish connection with the server
			socket = new Socket(host, 7001);
//			System.out.println("connection with server made");
//		}
//		catch (IOException ex) {
//			ex.printStackTrace();
//		}
		System.out.println("waiting for objects");
		ObjectInputStream recievedVillains = new ObjectInputStream(socket.getInputStream());


		recievedreadyVillains = (ArrayList<Object>) recievedVillains.readObject();
		System.out.println(recievedreadyVillains.get(0));
		
		socket.close();

		//		Socket socketThreads = null;
		//		
		//		
		//		socketThreads = new Socket(host, 7006);
		
		ReactID idVillains = new ReactID();
		for(int i = 0; i < recievedreadyVillains.size() ; i++ ){
			socket = new Socket(host, 7001);
			

			Object villain = recievedreadyVillains.get(i);
//			ObjectOutputStream sendHero = new ObjectOutputStream(keepSending.getOutputStream()); 
//			SuperHero hero = idVillains.id(villain);
//
//			if( hero  == null) {
//				Person itsAperson = new Person();
//				sendHero.writeObject(itsAperson);
//				
//			}
//
//			Thread.sleep(1000);
//			sendHero.writeObject(hero);
//			System.out.println("Sent Hero");

			sendHeroesThread t = new sendHeroesThread(socket,villain);
						t.start();
						t.sleep(10000);

		}

		socket.close();







	}


}


