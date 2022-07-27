import java.io.BufferedInputStream;
import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;

import java.net.Socket;

import java.util.Locale;


// This class boots up Server Socket 5001 and then looks for Client.
// It exchanges messages with Client.java once they successfully connect.
public class Server {

public static void main(String args[]) {

	try {

		String messageType = " ", text, status;

		ServerSocket theServerSocket = new ServerSocket(5001);

		System.out.println("Server is booting up...");

		while(true) {
			
			Socket theSocket = theServerSocket.accept();
			
			System.out.println("New client connected"+ theSocket.getInetAddress().getHostAddress());

			ClientHandler ClientSock = new ClientHandler(theSocket);
			new Thread(ClientSock).start();

		}
	}
	
	catch(IOException IOError) {

		IOError.printStackTrace();

	}
	


}
// ClientHandler class
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;
	
		// Constructor
		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}
		public void run(){
			
		
			try {
				InputStream buffer = new BufferedInputStream(clientSocket.getInputStream());
				
				ObjectInputStream input = new ObjectInputStream(buffer);
				
				User Temp = (User)input.readObject();
				
				System.out.print(Temp);
				
				
				

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException IOError) {

				IOError.printStackTrace();

			}


	}



	}
}