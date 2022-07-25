import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.ConnectException;

import java.net.Socket;

// This class boots up Server Socket 5001 and then looks for Server.
// It exchanges messages with Server.java once they successfully connect.
public class Client {

public static void main(String asd[]) {

	Socket theSocket = null;

	String text, status, type;

	try {

		theSocket = new Socket("localhost", 5001);
		
		System.out.println("Client is booting up...");

		DataOutputStream theOutput = new DataOutputStream(theSocket.getOutputStream());

		DataInputStream theInput = new DataInputStream(theSocket.getInputStream());

		BufferedReader theReader = new BufferedReader(new InputStreamReader(System.in));

	do {
		text = theReader.readLine();

		theOutput.writeUTF(text);

		System.out.println("Server Typed: " + theInput.readUTF());

		theOutput.flush();
	}

	while(!text.equalsIgnoreCase("logout"));

		System.out.println("Logging out...");

		theSocket.close();

	}

	catch(ConnectException ConnError) {

		System.out.println("The Server cannot be found.");

	}

	catch(IOException IOError){

		IOError.printStackTrace();

	}

}

}