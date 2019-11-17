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
			serverSocket = new ServerSocket(7003);
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


				//create and configure observer/able
				File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
				ServerObservable checkForVillians =  new ServerObservable();
				ServerObserver retriveVillians = new ServerObserver(socket);

				checkForVillians.addObserver(retriveVillians);
				checkForVillians.tempFile(temp);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

}
