import java.io.*;
import java.net.*;

public class Server {

	private DataInputStream inputFromClient;

	public static void main(String[] args) throws ClassNotFoundException {
		new Server();
	}

<<<<<<< Updated upstream
	public Server() {
		try {
			// Create a server socket
			ServerSocket serverSocket = new ServerSocket(8007);
			System.out.println("Server started ");
			while (true) {
				// Listen for a new connection request
				Socket socket = serverSocket.accept();

				// Create an input stream from the socket
				inputFromClient = new DataInputStream(socket.getInputStream());
				DataOutputStream 	toClientBoolean = new DataOutputStream(socket.getOutputStream());
				
				toClientBoolean.writeBoolean(false);
				

				// Read from input
				Object object = inputFromClient.readBoolean();
//				System.out.println("sent from client " + object);
//				System.out.println("im the server");
				
				

		
			
			//	serverSocket.close();
			}

		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
=======
	public Server() throws ClassNotFoundException {
		ServerSocket serverSocket = null;
		Socket socket = null;

		// Create a server socket

		try {
			serverSocket = new ServerSocket(8001);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server started ");

		try {
			socket = serverSocket.accept();
			

				//create and configure observer/able
				File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
				ServerObservable checkForVillians =  new ServerObservable();
				ServerObserver retriveVillians = new ServerObserver(socket);

				checkForVillians.addObserver(retriveVillians);
				checkForVillians.tempFile(temp);

				while (true) {
					// Listen for a new connection request
					new ClientHandler(serverSocket.accept()).start();;
				}


			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


>>>>>>> Stashed changes

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
