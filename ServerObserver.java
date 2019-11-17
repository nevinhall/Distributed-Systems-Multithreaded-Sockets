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

			//send boolean to client
//			DataOutputStream toClientBoolean = new DataOutputStream(socket.getOutputStream());
//			toClientBoolean.writeBoolean(false);
//			System.out.println("sentToclient");
//			toClientBoolean.close();

			//picks file to use
			FileInputStream fileToSend = new FileInputStream("D://college 2019//College third year//semester one//Disturbted systems//common//battle-zone-1.ser"); 
			
			//changes from file to serialised object
			Object convertedVillan = null; 
			ObjectInputStream villanFromFolder = new ObjectInputStream(fileToSend);
			convertedVillan= (Object)villanFromFolder.readObject();
			fileToSend.close();

			//sends file
			System.out.println("object sent");
			ObjectOutputStream toClientBattleZone = new ObjectOutputStream(socket.getOutputStream());
			toClientBattleZone.writeObject(convertedVillan);
			System.out.println("finished sending");
//			
			
			

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}


	}

}
