import java.io.*;
import java.net.*;

public class Server {

	private DataInputStream inputFromClient;

	public static void main(String[] args) {
		new Server();
	}

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

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
