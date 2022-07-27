import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
public class ContactList extends JFrame implements ActionListener {
 

	
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Contact List");
    JButton button1 = new JButton("");
    JButton button2 = new JButton("");
    JButton button3 = new JButton("");
    JButton button4 = new JButton("");
    JButton button5 = new JButton("Create Account");
    JButton button6 = new JButton("Display Log");
    Font titleFont = new Font("SansSerif", Font.BOLD, 15);
    String S1, S2, S3, S4;
    
    User CurrUser = new User();
    User ChatUser = new User();

    ContactList() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
    public void SetButtons() {
    	UserVerify TempUserLog = new UserVerify();
    	TempUserLog.LoadUserFile();
    	Integer i = 0;
    	for(User Iter: TempUserLog.GetVector()) {
    		if(this.CurrUser.GetId().equals(Iter.GetId())) {
    			i++;
    			continue;
    		}
    		if(button1.getText().equals("")) {
    			button1.setText(Iter.GetName());
    			S1 = Iter.GetId();
    			continue;
    		}
    		if(button2.getText().equals("")) {
    			button2.setText(Iter.GetName());
    			S2 = Iter.GetId();
    			continue;
    		}
    		if(button3.getText().equals("")) {
    			button3.setText(Iter.GetName());
    			S3 = Iter.GetId();
    			continue;
    		}
    		if(button4.getText().equals("")) {
    			button4.setText(Iter.GetName());
    			S4 = Iter.GetId();
    		}
   
    	}
    	
    	
    }
    
    
    
    public void SetUser(User user) {
    	this.CurrUser = user;
    }
    public void setLayoutManager() {
        container.setLayout(null);
    }
   
    public void setLocationAndSize() {
    	titleCard.setBounds(115, 50, 125, 50);
    	titleCard.setEditable(false);
    	titleCard.setFont(titleFont);
    	button1.setBounds(105, 150, 125, 30);
    	button2.setBounds(105, 220, 125, 30);
    	button3.setBounds(105, 290, 125, 30);
    	button4.setBounds(105, 360, 125, 30);
    	button5.setBounds(105, 460, 125, 30);
    	button6.setBounds(105, 500, 125, 30);

    }
 
    public void addComponentsToContainer() {
    	container.add(titleCard);
    	container.add(button1);
    	container.add(button2);
    	container.add(button3);
    	container.add(button4);
    	container.add(button5);
    	container.add(button6);
    	

    }
 
    public void addActionEvent() {
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    	button5.addActionListener(this);
    	button6.addActionListener(this);

    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
    	UserVerify TempUserLog = new UserVerify();
    	TempUserLog.LoadUserFile();

    	
    	
        if (e.getSource() == button1) {
        	JOptionPane.showMessageDialog(this, "Redirecting to " + button1.getText());
        	ChatUser.SetID(S1);
        	// Opens Chat Interface
            Chat frame = new Chat();   
            
            frame.SetUser(CurrUser);
            frame.SetOtherUser(ChatUser);
            frame.SetText();
            
            frame.setTitle("Chat");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }

        if (e.getSource() == button2) {
        	JOptionPane.showMessageDialog(this, "Redirecting to " + button2.getText() );
        	ChatUser.SetID(button2.getText()); 
        	ChatUser.SetID(S2);
        	
        	Chat frame = new Chat();
        	
        	frame.SetUser(CurrUser);
            frame.SetOtherUser(ChatUser);
            frame.SetText();
            
            frame.setTitle("Chat");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
        
        if (e.getSource() == button3) {
        	JOptionPane.showMessageDialog(this, "Redirecting to " + button3.getText());
        	ChatUser.SetID(button3.getText()); 
        	ChatUser.SetID(S3);
        	
        	Chat frame = new Chat();
        	
        	frame.SetUser(CurrUser);
            frame.SetOtherUser(ChatUser);
            frame.SetText();
            
            frame.setTitle("Chat");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
        
        if (e.getSource() == button4) {
        	JOptionPane.showMessageDialog(this, "Redirecting to " + button4.getText());
        	ChatUser.SetID(button4.getText()); 
        	ChatUser.SetID(S4);
        	
        	Chat frame = new Chat();
        	
        	frame.SetUser(CurrUser);
            frame.SetOtherUser(ChatUser);
            frame.SetText();
            
            frame.setTitle("Chat");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
       if(e.getSource() == button5) {
    	   String Name = JOptionPane.showInputDialog("Enter Name : ");
    	   String ID = JOptionPane.showInputDialog("Enter ID : ");
    	   String Password = JOptionPane.showInputDialog("Enter Password : ");
    	   String IsIT = JOptionPane.showInputDialog("Enter 1 for IT, 0 For Not IT : ");
    	   Integer It;
    	   if(IsIT.equals("1")) {
    		   It = 1;
    	   }
    	   else {
    		   It = 0;
    	   }
    	   User Temp = new User();
    	   CurrUser.CreateAccount_IT(Name, ID, Password, It);
    	   
       }
      if(e.getSource() == button6) {
    	  JOptionPane.showMessageDialog(null, CurrUser.displayMessage_IT());
      }
    }
 
}
 