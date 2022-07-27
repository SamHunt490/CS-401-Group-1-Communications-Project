import java.io.*;
import java.util.*;

public class UserVerify {
	private String FileName = "User.txt";
	private static Vector <User> UserLog;
	
	public UserVerify() {
		UserLog = new Vector<User>();
	}
	// If There Exist Another Txt FIle Instead Of Default One
	public UserVerify(String File) {
		this.FileName = File;
		UserLog = new Vector<User>();
	}
	public String GetFile() {
		return this.FileName;
	}
	public void SetFile(String File) {
		this.FileName = File;
	}
	public void addUser_IT(User New) {
		UserLog.add(New);
		SaveUserFile();
	}
	public User SearchUser(User Login) {
		for( User Iter : UserLog) {
			if(Iter.GetId().equals(Login.GetId())) {
				if(Iter.GetPass().equals(Login.GetPass())) {
					// If True Then Login ID AND PASS ARE VALID
					
					return Iter;
				}
			}
		}
		// USER DOES NOT EXIST IN DATA FILE
		return null;
	}
	public void SaveUserFile() {
		String Combined = "";
		String  IsTrue;
		try {	
			for (User Iter : UserLog) {
				if(Iter.GetIT()) {
					IsTrue = "1";
				}
				else {
					IsTrue = "0";
				}
				Combined += Iter.GetName() + "," + Iter.GetId() + "," + Iter.GetPass() + "," + IsTrue + "\n";
				// Debug PURPOSES
				// System.out.println("-\n" +Combined);
			}
			FileWriter Writer = new FileWriter(this.FileName, false);
			Writer.write(Combined);
			Writer.close();
		}
		catch(Exception e) {
			return;
		}
	}
	public void LoadUserFile() {
		File myfile = new File(this.FileName);
		try {
			Scanner sc = new Scanner(myfile);
			sc.useDelimiter(",");
			String Name, Id, Password, IsIT; 
			Integer ISIT;
			User Temp = null;
			while(sc.hasNext()) {
				Name = sc.next();
				Id = sc.next();
				Password = sc.next();
				IsIT = sc.nextLine();
				if(IsIT.substring(1).equals("1")) {
					ISIT = 1;
				}
				else {
					ISIT = 0;
				}
				// SubString 1 On Txt To Get Rid Of The Comma It Reads
				Temp = new User(Name, Id, Password, ISIT); 
				UserLog.add(Temp);
	

				// DEBUG PURPOSES ONLY , PRINTS OUT VECTOR
				// System.out.print(Temp);
			
			}
			sc.close();
		}
		catch(Exception e) {
			// IF FILE DOES NOT EXIST
			return;
		}
	}
	public Vector<String>GetUserId(){
		Vector<String> Temp = new Vector<String>();
		for(User UserId : UserLog) {
			Temp.add(UserId.GetId());
		}
		return Temp;
	}
	public Vector<User> GetVector(){
		return UserLog;
	}
	
}
