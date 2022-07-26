import java.util.Vector;
import java.io.*;

//	No Setters Since Only IT Users Can Create Accounts
//  No Statics ID For That Same Reasoning
//  There Are IT Methods But Will Check IT_USer BOOL to determine that user can use it.


public class User {
	private String EmployeeName;
	private String Id;
	private String Pass;
	private Boolean IT_User;
	
	// General Constructor
	public User() {
		this.EmployeeName = null;
		this.Id = null;
		this.Pass = null;
		this.IT_User = false;
	}
	
	// Integer IT Determines Whether User Is IT Role
	// 0 = False
	// 1 = True
	public User(String Name, String ID, String Password, Integer IT) {
		Boolean Temp = null;
		if(IT == 0) {
			Temp = false;
		}
		else {
			Temp = true;
		}
		this.EmployeeName = Name;
		this.Id = ID;
		this.Pass = Password;
		this.IT_User = Temp;
	}
	public User CreateAccount_IT(String Name, String ID, String Password, Integer IT) {
		// This Method Will Only Run If User Is IT
		if(this.IT_User) {
			User Temp = new User(Name, ID, Password, IT);
			return Temp;
		}
		else {
			return null;
		}
	}
	public void CreateGroup(String GroupName) {
		// TODO NEED GROUP CLASSES 
		//
		//
	}
	public void SendMessage(Message Msg) {
		MessageLog TempLog = new MessageLog();
		TempLog.addMessage(Msg);
		TempLog.SaveMsgLog();
	}
	public Vector<Message> displayMessage(String Other){
		Vector<Message> Temp = new Vector<Message>();
		MessageLog TempLog = new MessageLog();
		TempLog.LoadMsgFile();
		return TempLog.SearchMsgLog(this.Id, Other);
	}
	public Vector<Message> displayMessage_IT(){
		if(this.IT_User) {
			MessageLog TempLog = new MessageLog();
			TempLog.LoadMsgFile();
			return TempLog.getVector();
		}
		else {
			return null;
		}
	}

	public String toString() {
		String Combined = this.EmployeeName + "/" + this.Id + "/" + this.Pass + "/" + this.IT_User + "\n";
		return Combined;
	}
}
