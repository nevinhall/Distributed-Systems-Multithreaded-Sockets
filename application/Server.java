package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	private DataInputStream inputFromClient;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Server();

	}

	public Server() throws ClassNotFoundException, IOException {
		ServerSocket serverSocket = null;


		// Create a server socket

		try {
			serverSocket = new ServerSocket(8007);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Server started ");





		//create and configure observer/able
		File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
		ServerObservable checkForVillians =  new ServerObservable();
		ServerObserver retriveVillians = new ServerObserver();
		serverClientArrayList arrayOfVillians =  new serverClientArrayList();
		ArrayList<Object> readyVillains;


		Socket socket = null;
		socket = serverSocket.accept();

		retriveVillians.setTemp(temp);
		retriveVillians.setSendVillains(arrayOfVillians);


		checkForVillians.addObserver(retriveVillians);
		checkForVillians.tempFile(temp);

		System.out.println("shouldbe delted by now");

		
		readyVillains = arrayOfVillians.getFoundVillains();
		//		
		//		ObjectOutputStream sendvillain= new ObjectOutputStream(socket.getOutputStream()); 
		//		sendvillain.writeObject(readyVillains);
		//		System.out.println("Sent Villains");
		//		

		socket.close();

		//loop to keep checking for clients wanting to join
		while(true) {
			Socket socketinner = null;

			try {
				socketinner = serverSocket.accept();
				System.out.println("New connection made");

				//				ObjectOutputStream sendvillain= new ObjectOutputStream(socketinner.getOutputStream()); 
				//				sendvillain.writeObject(readyVillains);
				//				






			} catch(Exception e) {
				socket.close();
				serverSocket.close();
				e.printStackTrace();

			}
		}
	}
}