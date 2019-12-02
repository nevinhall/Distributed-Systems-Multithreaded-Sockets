package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private DataInputStream inputFromClient;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Server();
		
	}

	public Server() throws ClassNotFoundException, IOException {
		ServerSocket serverSocket = null;


		// Create a server socket

		try {
			serverSocket = new ServerSocket(8002);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server started ");





		//create and configure observer/able
		File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
		ServerObservable checkForVillians =  new ServerObservable();
		ServerObserver retriveVillians = new ServerObserver();
		retriveVillians.setTemp(temp);


		checkForVillians.addObserver(retriveVillians);
		checkForVillians.tempFile(temp);

		//loop to keep checking for clients wanting to join
		while(true) {
			Socket socket = null;

			try {
				socket = serverSocket.accept();
				System.out.println("New connection made");
				
				DataOutputStream sendvillain= new DataOutputStream(socket.getOutputStream()); 







			} catch(Exception e) {
				socket.close();
				serverSocket.close();
				e.printStackTrace();
				
			}
		}
	}
}