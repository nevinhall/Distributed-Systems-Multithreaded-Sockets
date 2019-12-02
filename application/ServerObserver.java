package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ServerObserver  implements Observer{
	private File temp;
	private int i = 1;
	private File deleteVillain;
	private FileInputStream idTemp;
	private Object objectFound;


	private serverClientArrayList sendVillains;



	@Override
	public void update(Observable o, Object arg) {

		//		foundVillains.add( temp.listFiles(new FilenameFilter() {
		//			public boolean accept(File dir, String name) {
		//				return name.startsWith("battle-zone-"+i) && name.endsWith("ser");
		//			}
		//		}));
		//		



		deleteVillain = new File("D://college 2019//College third year//semester one//Disturbted systems//common//battle-zone-" + i + ".ser");
		System.out.println(i + " this is the current value");

		//
		//		System.out.println("Array size: " + foundVillains.size());
		//		System.out.println("File to delete " + deleteVillain.getName());




		try {
			idTemp = new FileInputStream(deleteVillain);
			
			System.out.println("should be deleted");


			ObjectInputStream in;

			in = new ObjectInputStream(idTemp);
			
			objectFound = (Object)in.readObject();
			sendVillains.add(objectFound, deleteVillain);
			idTemp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n file contains " + objectFound.getClass());
		

		deleteVillain.delete();
		
		i++;




	}

	public File getTemp() {
		return temp;
	}

	public void setTemp(File temp) {
		this.temp = temp;
	}
	
	public serverClientArrayList getSendVillains() {
		return sendVillains;
	}

	public void setSendVillains(serverClientArrayList sendVillains) {
		this.sendVillains = sendVillains;
	}



}
