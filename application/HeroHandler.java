package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HeroHandler extends Thread{
	private Socket socket;
	private int numHero;

	public HeroHandler(int heroNum,Socket socket) {
		this.numHero = heroNum;
		this.socket = socket;

	}

	public void run() {
		System.out.println("New connection made");
		try {

		

			File destination = new File ("D://college 2019//College third year//semester one//Disturbted systems//common//saved-the-world-again//saved" +  numHero + ".ser");

			FileOutputStream fileOut;

			fileOut = new FileOutputStream(destination);

			//ObjectOutputStream out = new ObjectOutputStream(fileOut);
			//out.writeObject(hero);
			//out.close();
			fileOut.close();
			System.out.printf("Serialized data succesfully \n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
