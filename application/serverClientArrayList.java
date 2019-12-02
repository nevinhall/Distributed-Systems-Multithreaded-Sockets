package application;

import java.io.File;
import java.util.ArrayList;

public class serverClientArrayList {

	private ArrayList<Object> foundVillains= new ArrayList<Object>();

	public void add(Object villainTOadd, File deleteloc){
		foundVillains.add(villainTOadd);
		System.out.println("New Villain Added, deleting from file location");

		System.out.println("Size of arrray should be equal to num villains : " + foundVillains.size());
		
	}

	public ArrayList<Object> getFoundVillains() {
		return foundVillains;
	}

	public void setFoundVillains(ArrayList<Object> foundVillains) {
		this.foundVillains = foundVillains;

	}
}