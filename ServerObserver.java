import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class ServerObserver  implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//test.txt");
		File success = new File("D://college 2019//College third year//semester one//Disturbted systems//common//testSuccesful.txt");
		
		temp.renameTo(success);
		
	}

}
