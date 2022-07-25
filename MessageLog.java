import java.io.*;
import java.util.*;

public class MessageLog {
	private Vector <Message> MsgLog; 
	private String FileName;
	private boolean modified;
	
	public MessageLog(){
		this.FileName = null;
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
		int i = 0;
		for(Message Iter : this.MsgLog) {
			System.out.println(i);
			if(Iter.GetSender().equals(Self) && Iter.GetReciever().equals(Other)) {
				Temp.add(Iter);
			}

		}
		return Temp;
	}
	public void addMessage(Message New) {
		this.modified = true;
		this.MsgLog.add(New);
	}
	public void LoadMsgFile(String file) {
		File myfile = new File(file);
		this.FileName = file;
		try {
			Scanner sc = new Scanner(myfile);
			sc.useDelimiter(",");
			String Self, Other, Timestamp, Txt, Read; 
			Boolean isTrue;
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
				if(Read.equals("0")) {
					Temp.HasRead();
				}
				// Adds Message To The Vector Of Messages
				addMessage(Temp);

				// DEBUG PURPOSES ONLY , PRINTS OUT VECTOR
				System.out.print(Temp);
			}
			this.modified = false;
		}
		catch(Exception e) {
			// IF FILE DOES NOT EXIST
			return;
		}
	}
	public void SaveMsgLog() {
		if(modified) {
			// Only Overwrites txt file If Modified Is true
			File myfile = new File(this.FileName);
			String Combined = "";
			String  IsTrue;
			try {	
				for (Message Iter : this.MsgLog) {
					if(Iter.GetRead()) {
						IsTrue = "0";
					}
					else {
						IsTrue = "1";
					}
					Combined += Iter.GetSender() + "," + Iter.GetReciever() + "," + Iter.GetTimeStamp() + "," + IsTrue + "," + Iter.GetContent() + "\n";
					System.out.println(Combined);
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
		return this.MsgLog;
	}
}
