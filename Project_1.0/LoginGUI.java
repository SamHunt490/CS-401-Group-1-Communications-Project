import java.util.Vector;

import javax.swing.JOptionPane;

public class LoginGUI {
	
	private User user;
	
	public LoginGUI(User Temp) {
		user = Temp;
	}
	
	 public void processCommands()
	 {
		 String ID = JOptionPane.showInputDialog("Enter Id");
		 if (ID == null) {
				return;		// dialog was cancelled
		}
		 String Password = JOptionPane.showInputDialog("Enter Password");
		if (Password == null) {
				return;		// dialog was cancelled
		}
		
		user.SetID(ID);
		user.SetPass(Password);
		// System.exit(0);
	 }
	 public User GetUser() {
		 return this.user;
	 }
	 //Display ALL
	 public void displayMessage(){
		System.out.println(user);
		JOptionPane.showMessageDialog(null,this.user.displayMessage_IT() , "MessageLog", JOptionPane.PLAIN_MESSAGE, null);
	 }
	 //Display With Other
	 public void displayMessage(User Temp){
			System.out.println(user);
			JOptionPane.showMessageDialog(null,this.user.displayMessage(Temp.GetId()) , "MessageLog", JOptionPane.PLAIN_MESSAGE, null);
		 }
}
