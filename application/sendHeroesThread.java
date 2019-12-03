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
		
		
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}

}
