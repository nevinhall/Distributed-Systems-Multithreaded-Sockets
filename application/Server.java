package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
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

		//create and configure observer/able
		File temp = new File("D://college 2019//College third year//semester one//Disturbted systems//common//");
		ServerObservable checkForVillians =  new ServerObservable();
		ServerObserver retriveVillians = new ServerObserver();
		serverClientArrayList arrayOfVillians =  new serverClientArrayList();
		ArrayList<Object> readyVillains = null;

		retriveVillians.setTemp(temp);
		retriveVillians.setSendVillains(arrayOfVillians);


		checkForVillians.addObserver(retriveVillians);
		checkForVillians.tempFile(temp);

		System.out.println("shouldbe delted by now");

		try {
			serverSocket = new ServerSocket(7008);

			System.out.println("Server started ");

			//loop to keep checking for clients wanting to join
			int i = 1;
			boolean flag = true;
			Socket socket = null;
			while(flag) {
				 socket = serverSocket.accept();

				System.out.println("Client connected no " + i);

				if(i == 1){
					readyVillains = arrayOfVillians.getFoundVillains();
					System.out.println("The villain array size should equal num villains it is, " + readyVillains.size());

					ObjectOutputStream sendvillain= new ObjectOutputStream(socket.getOutputStream()); 
					sendvillain.writeObject(readyVillains);
					System.out.println("Sent Villains");
					sendvillain.reset();
				}


				if( i > 1) {
					new HeroHandler(i, socket).start();
				}



				if(i == readyVillains.size() ) {
					flag = false;
				}
				i++;
			
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}