import java.io.File;
import java.util.Observable;

public class ServerObservable extends Observable {
	public void tempFile(File fileDir) {

		//loop doesnt work goes too far
		Boolean exists = true;
		
		while(exists == true){
			System.out.println("The given Directory exists, notifying observers");
			setChanged();
			notifyObservers(fileDir);
			exists = fileDir.exists() && fileDir.list().length != 1;
			System.out.println("reached");
			
			if(fileDir.list().length == 1){
				exists = false;
				//have to also tell client to run
				

			}


		}


	}

}
