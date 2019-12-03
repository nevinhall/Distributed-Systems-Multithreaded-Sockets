package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class sendHeroesThread extends Thread{
	Socket socketThreads;
	Object villain;
	private ReactID idVillains = new ReactID();

	public sendHeroesThread(Socket socketThreads, Object villain) {
		this.villain = villain;
		this.socketThreads = socketThreads;
	}
	
	public void run() {
		try {
		  SuperHero hero = idVillains.id(villain);
			ObjectOutputStream sendHero = new ObjectOutputStream(socketThreads.getOutputStream()); 
			sendHero.writeObject(hero);
			System.out.println("Sent Hero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
