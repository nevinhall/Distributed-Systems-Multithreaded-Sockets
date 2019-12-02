import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerHandler extends Thread {
	private Socket serverSocket;

	public ServerHandler(Socket socket) {
	this.serverSocket = socket;
	}
	
	public void run() {

		try {
			ObjectInputStream heroFromClient = new ObjectInputStream(serverSocket.getInputStream());
			System.out.println(heroFromClient.toString());

			while(heroFromClient != null) {
				Object recievedHero = heroFromClient.readObject();
				
				//Create I/O to allow client to recieve villian objects
				ObjectInputStream villansFromServer = new ObjectInputStream(serverSocket.getInputStream());
				Object recievedVillain = villansFromServer.readObject();
				villansFromServer.close();
				
			
				

				//Allows for a hero object to be created in response to the sent villain
				ReactID createHero = new ReactID();
				createHero.setSocket(serverSocket);  
				createHero.id(recievedVillain);
				

				//Recieve and deserialise objects from server
				File destination = new File ("D://college 2019//College third year//semester one//Disturbted systems//common//saved-the-world-again//test"  + 1 + ".ser");
				FileOutputStream fileOut =	new FileOutputStream(destination);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(recievedHero);
				out.close();
				fileOut.close();
			}

			serverSocket.close();
		}catch(IOException | ClassNotFoundException e){
		}
	}
	

}
