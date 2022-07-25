import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

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

		Socket theSocket = theServerSocket.accept();

		DataInputStream theInput = new DataInputStream(theSocket.getInputStream());

		DataOutputStream theOutput = new DataOutputStream(theSocket.getOutputStream());

		BufferedReader theReader = new BufferedReader(new InputStreamReader(System.in));

		while(!theServerSocket.isClosed()) {

			if(messageType.equalsIgnoreCase("logout")) {

				status = "success";

				System.out.println("Logging out...");

				System.out.println("Client is: "+status);

				theOutput.flush();

				theOutput.close();

			}

			else if(messageType.equalsIgnoreCase("login")) {

				text = (String)theInput.readUTF();

				System.out.println("Client is: " + text.toUpperCase(Locale.ENGLISH));

			}

			else {

				text = theReader.readLine();

				theOutput.writeUTF(text);

				System.out.println("Client Typed: " + theInput.readUTF());

				theOutput.flush();

			}

		}

		System.out.println("The Server has Stopped.");

	}
	
	catch(IOException IOError) {

		IOError.printStackTrace();

	}

}

}