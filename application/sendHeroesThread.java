package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import villians.Person;

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
			ObjectOutputStream sendHero = new ObjectOutputStream(socketThreads.getOutputStream()); 
			SuperHero hero = idVillains.id(villain);

			if( hero  == null) {
				Person itsAperson = new Person();
				sendHero.writeObject(itsAperson);
				
			}

			Thread.sleep(1000);
			sendHero.writeObject(hero);
			System.out.println("Sent Hero");
		
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
