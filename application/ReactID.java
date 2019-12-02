package application;



import java.io.File;
import java.io.IOException;
import java.net.Socket;

import villians.BadFlyPerson;
import villians.BadStrongMan;
import villians.Person;

public class ReactID {

	Object verified;
	File confirmedPath;
	Socket socket;


	public  SuperHero id(Object getID) throws IOException {
		verified = getID.getClass();

		GoodFlyPersonFactory GoodFlyPersonFactory = new GoodFlyPersonFactory();
		GoodStrongManFactory GoodStrongManFactory = new GoodStrongManFactory();

		BadFlyPerson potentialCandidate1 = new BadFlyPerson(0);
		BadStrongMan potentialCandidate2 = new BadStrongMan(0);
		Person potentialCandidate3 = new Person();


		if(verified.equals(potentialCandidate1.getClass())){
			System.out.println("its a badflyperson object sent from server ");
			SuperHero succesfulID1 = GoodFlyPersonFactory.GoodFlyPersonMaker();
			return succesfulID1;



		}else if(verified.equals(potentialCandidate2.getClass())){
			System.out.println("its a badstrongMan object sent from server ");
			SuperHero succesfulID2 = GoodStrongManFactory.GoodStrongManMaker();
			return succesfulID2;



		}else if(verified.equals(potentialCandidate3.getClass())) {
			System.out.println("its a Person object sent from server ");
			return null;



		}else {
			System.out.println("failed to ID");
		}
		return null;

	}


	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}




}
