import java.io.*;
import java.net.*;
import java.util.Observable;

public class Server   {

	private DataInputStream inputFromClient;

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		// Create a server socket

		try {
			serverSocket = new ServerSocket(7992);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server started ");

		try {
			while (true) {
				// Listen for a new connection request
				socket = serverSocket.accept();
			
				System.out.println(socket.isClosed());

				// Create an input stream from the socket
				//	inputFromClient = new DataInputStream(socket.getInputStream());
				//DataOutputStream toClientBoolean = new DataOutputStream(socket.getOutputStream());

				//create and configure observer/able
				File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
				ServerObservable checkForVillians =  new ServerObservable();
				ServerObserver retriveVillians = new ServerObserver(socket);

				checkForVillians.addObserver(retriveVillians);
				checkForVillians.tempFile(temp);

				//send to db
				//				toClientBoolean.writeBoolean(false);


				// Read from input
				//				Object object = inputFromClient.readBoolean();
				//				System.out.println("sent from client " + object);
				//				System.out.println("im the server");



			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
