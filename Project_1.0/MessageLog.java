import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MessageLog {
	// One Main MessageLog That Contains ALL MESSAGES
	private static Vector <Message> MsgLog; 
	private String FileName = "messageLog.txt";
	// Only Needs 1 modification bool
	private static boolean modified;
	
	public MessageLog(){
		//this.FileName = null;
		MsgLog = new Vector<Message>();
	}
	public MessageLog(String File){
		this.FileName = File;
		MsgLog = new Vector<Message>();
	}
	public String GetFile() {
		return this.FileName;
	}
	public void SetFile(String File) {
		this.FileName = File;
	}
	public Vector<Message> SearchMsgLog(String Self, String Other){
		Vector<Message> Temp = new Vector<Message>();
		// Loop Through MsgLog With If Condition
		// Returns A Message Type Vector
		for(Message Iter : MsgLog) {
			if(Iter.GetSender().equals(Self) && Iter.GetReciever().equals(Other)) {
				Temp.add(Iter);
				// If Message is Pulled Then It Has Been Read
				Iter.HasRead();
			}

		}
		return Temp;
	}
	// add message from data file
	public void addMessage(Message New) {
		modified = true;
		MsgLog.add(New);
	}
	// adding brand new message
	public void addMessage(String Self, String Other, String Content ) {
		String CurrTime = new SimpleDateFormat("YYYY.MM.dd").format(new Date()); 
		MessageType Type = MessageType.TEXTMESSAGE;
		Message Temp = new Message(Self, Other, Content, CurrTime, Type);
		addMessage(Temp);
		
	}
	public void LoadMsgFile() {
		File myfile = new File(this.FileName);
		try {
			Scanner sc = new Scanner(myfile);
			sc.useDelimiter(",");
			String Self, Other, Timestamp, Txt, Read; 
			Message Temp = null;
			// Since Only TxtMessage Types Are Stored
			MessageType Type = MessageType.TEXTMESSAGE;
			while(sc.hasNext()) {
				Self = sc.next();
				Other = sc.next();
				Timestamp = sc.next();
				Read = sc.next();
				// Reads Rest Of The Line Into Txt
				Txt = sc.nextLine();
				// Creates Temp Message Type Object To Store Data Gain From Data File
				// SubString 1 On Txt To Get Rid Of The Comma It Reads
				Temp = new Message(Self, Other, Txt.substring(1), Timestamp, Type ); 
				// Checks For If Message Has Read Is True Or Not
				if(Read.equals("1")) {
					Temp.HasRead();
				}
				// Adds Message To The Vector Of Messages
				addMessage(Temp);

				// DEBUG PURPOSES ONLY , PRINTS OUT VECTOR
				// System.out.print(Temp);
			}
			sc.close();
			modified = false;
		}
		catch(Exception e) {
			// IF FILE DOES NOT EXIST
			return;
		}
	}
	public void SaveMsgLog() {
		if(modified) {
			String Combined = "";
			String  IsTrue;
			try {	
				for (Message Iter : MsgLog) {
					if(Iter.GetRead()) {
						IsTrue = "1";
					}
					else {
						IsTrue = "0";
					}
					Combined += Iter.GetSender() + "," + Iter.GetReciever() + "," + Iter.GetTimeStamp() + "," + IsTrue + "," + Iter.GetContent() + "\n";
					// Debug PURPOSES
					// System.out.println(Combined);
				}
				FileWriter Writer = new FileWriter(this.FileName, false);
				Writer.write(Combined);
				Writer.close();
			}
			catch(Exception e) {
				return;
			}
		}
		
	}
	
	public Vector<Message> getVector(){
		return MsgLog;
	}
}
