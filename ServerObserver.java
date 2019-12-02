import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ServerObserver  implements Observer{
	private File temp;
	private ArrayList<Object> foundVillains= new ArrayList<Object>();
	private int i = 1;
	private File deleteVillain;

	@Override
	public void update(Observable o, Object arg) {
		
		 foundVillains.add( temp.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith("battle-zone-"+i) && name.endsWith("ser");
		    }
		}));
		
		deleteVillain = new File("D://college 2019//College third year//semester one//Disturbted systems//common//battle-zone-" + i + ".ser");
		
		System.out.println("Array size: " + foundVillains.size());
		System.out.println("File to delete " + deleteVillain.getName());
		deleteVillain.delete();
		
		i++;

	}

	public File getTemp() {
		return temp;
	}

	public void setTemp(File temp) {
		this.temp = temp;
	}

	public ArrayList<Object> getFoundVillains() {
		return foundVillains;
	}

	public void setFoundVillains(ArrayList<Object> foundVillains) {
		this.foundVillains = foundVillains;
	}

}
