import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ServerObserver  implements Observer{
	Socket socket = null;

	public ServerObserver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void update(Observable o, Object arg) {

		int numThreadsRequired =  new File("D://college 2019//College third year//semester one//Disturbted systems//common//").list().length;


		try {
		
		
			
			
			//			FileInputStream fileToSend = new FileInputStream("D://college 2019//College third year//semester one//Disturbted systems//common//testSuccesful.ser"); 
			//
			//
			//			System.out.println("start of update");
			//
			//
			//
			//
			//			ObjectOutputStream toClientBattleZone = new ObjectOutputStream(socket.getOutputStream());
			//
			//			Object objectFound = null; 
			//			ObjectInputStream in = new ObjectInputStream(fileToSend);
			//			objectFound = (Object)in.readObject();
			//			fileToSend.close();
			//
			//			System.out.println("object serilaised");
			//			toClientBattleZone.writeObject(objectFound);
			

			DataOutputStream toClientBoolean = new DataOutputStream(socket.getOutputStream());
			toClientBoolean.writeBoolean(false);
			System.out.println("sentToclient");


		}

		catch (Exception ex) {
			ex.printStackTrace();
		}


	}

}
