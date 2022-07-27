import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.net.ConnectException;

import java.net.Socket;

import javax.swing.JFrame;

import java.io.*;
// This class boots up Server Socket 5001 and then looks for Server.
// It exchanges messages with Server.java once they successfully connect.
public class Client {

public static void main(String asd[]) {

	Socket theSocket = null;

	String UserName, Password, text, status, type;
	
	User Temp = new User();
	
	try {

		theSocket = new Socket("localhost", 5001);
		
		System.out.println("Client is booting up...");

		DataOutputStream theOutput = new DataOutputStream(theSocket.getOutputStream());

		DataInputStream theInput = new DataInputStream(theSocket.getInputStream());

		BufferedReader theReader = new BufferedReader(new InputStreamReader(System.in));
		///////////////////////////////////
		OutputStream buffer = new BufferedOutputStream(theSocket.getOutputStream());
		
		ObjectOutputStream out = new ObjectOutputStream(buffer);
		////////////////////////////////
	do {
		// Prompts User To Enter ID
		System.out.println("Enter ID");
		
		UserName = theReader.readLine();
		
		System.out.println("Enter Password");
		
		Password = theReader.readLine();
		

		
		
		Temp.SetID(UserName);
		Temp.SetPass(Password);
		System.out.print(Temp);
		
		out.writeObject(Temp);
		
		out.flush();
		//theOutput.writeUTF(text);

		
		
		
		
		
		
		
		
		
		
		System.out.println("Server Typed: " + theInput.readUTF());

		theOutput.flush();
	}

	while(!UserName.equalsIgnoreCase("logout"));

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