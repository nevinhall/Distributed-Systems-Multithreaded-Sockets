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

		socket = new Socket(host, 7008);

		System.out.println("waiting for objects");
		ObjectInputStream recievedVillains = new ObjectInputStream(socket.getInputStream());
		recievedreadyVillains = (ArrayList<Object>) recievedVillains.readObject();

		System.out.println(recievedreadyVillains.get(0));
		socket.close();



		ReactID idVillains = new ReactID();
		for(int i = 0; i < recievedreadyVillains.size() ; i++ ){
			socket = new Socket(host, 7008);

			Object villain = recievedreadyVillains.get(i);
			sendHeroesThread t = new sendHeroesThread(socket,villain);
			t.start();
			t.sleep(10000);

		}

		socket.close();

	}


}


