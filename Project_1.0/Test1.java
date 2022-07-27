import java.io.*;

public class Test1 {
	public static void main(String args[]) {
		//UserVerify Test2 = new UserVerify();
		//Test2.LoadUserFile();
		//User Test1 = new User("BOB", "ID001", "wasd", 1);
		//User Test3 = new User("Ew", "ID050", "Pass", 0);
	/*	
		if(Test2.SearchUser(Test3)) {
			System.out.println("IN");
		}
		if(Test2.SearchUser(Test1)) {
			System.out.println("IN");
		}
	*/
		//System.out.println(Test1);
		//Test1.CreateAccount_IT("New", "ID002", "Password", 0);
		//Test3.CreateAccount_IT("Who", "ID003", "This", 1);
		//System.out.print(Test1.displayMessage_IT());
		//System.out.println(Test1.displayMessage("They"));
		
		
		
		//System.out.print(Test2.GetVector());
		
		
		//LoginGUI TEMP = new LoginGUI;
		//User Test1 = new User("BOB", "ID001", "wasd", 1);
	//	System.out.println(Test1);
		//System.out.println(Test1.CreateGroup("groupname"));
		
		UserVerify Test = new UserVerify();
		Test.LoadUserFile();
		System.out.println(Test.DisplayUsers());
			
		
		
	}
}
