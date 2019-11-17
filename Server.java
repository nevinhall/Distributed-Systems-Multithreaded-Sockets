import java.io.*;
import java.net.*;
import java.util.Observable;

public class Server   {

	private DataInputStream inputFromClient;

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8009);
			System.out.println("Server started ");
			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();

				// Create an input stream from the socket
				inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream toClientBoolean = new DataOutputStream(socket.getOutputStream());
				
				//create and configure observer/able
				File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
				ServerObservable checkForVillians =  new ServerObservable();
				ServerObserver retriveVillians = new ServerObserver();
				
				checkForVillians.addObserver(retriveVillians);
				checkForVillians.tempFile(temp);
				
				//send to db
//				toClientBoolean.writeBoolean(false);
				

				// Read from input
//				Object object = inputFromClient.readBoolean();
//				System.out.println("sent from client " + object);
//				System.out.println("im the server");
				
				
				

		
			
				serverSocket.close();
			}

		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
