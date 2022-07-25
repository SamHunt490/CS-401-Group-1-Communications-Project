import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Message {
	private String Sender;
	private String Reciever;
	private String Content;
	private Boolean Read;
	private String TimeStamp;
	private MessageType Type;
	
	public Message() {
		this.Sender = "Undefined";
		this.Reciever = "Undefined";
		this.Content = "Undefined";
		this.Read = false;
		this.TimeStamp = new SimpleDateFormat("YYYY.MM.dd").format(new Date());
		this.Type = null;
	}
	public Message(String Self,String Other,String Txt,String Time,MessageType MsgType) {
		this.Sender = Self;
		this.Reciever = Other;
		this.Content = Txt;
		this.Read = false;
		this.TimeStamp = Time;
		this.Type = MsgType;
	}
	public String GetSender() {
		return this.Sender;
	}
	public String GetReciever() {
		return this.Reciever;
	}
	public String GetContent() {
		return this.Content;
	}
	public Boolean GetRead() {
		return this.Read;
	}
	public String GetTimeStamp() {
		return this.TimeStamp;
	}
	public MessageType GetType() {
		return this.Type;
	}
	public void HasRead() {
		this.Read = true;
	}
	public String toString() {
		String BoolString = null;
		if(this.Read) {
			BoolString = "true";
		}
		else {
			BoolString = "false";
		}

		String Combined = this.Sender + "\n" +
						  this.Reciever + "\n" +
						  this.Content + "\n" +
						  this.TimeStamp + "\n" +
						  BoolString + "\n" +
						  this.Type + "\n\n";
		
		return Combined;
	}
}

enum MessageType{
	LOGINUSERNAME, LOGINPASSWORD, TEXTMESSAGE;
}