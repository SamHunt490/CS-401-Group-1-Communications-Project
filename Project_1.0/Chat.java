import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
public class Chat extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Chat");
    JTextField button1 = new JTextField("");
    JTextField button2 = new JTextField("");
    JTextField button3 = new JTextField("");
    JTextField button4 = new JTextField("");
    
    Font titleFont = new Font("SansSerif", Font.BOLD, 15);
    
    User CurrUser = new User();
    User OtherUser = new User();
    MessageLog MsgLog = new MessageLog();
    
    Chat() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
    public void SetUser(User Temp) {
    	this.CurrUser = Temp;
    	this.MsgLog.LoadMsgFile();
    }
    public void SetOtherUser(User Temp) {
    	this.OtherUser = Temp;
    }
    //
   public void SetText() {
	   MsgLog.LoadMsgFile();
	   for(Message Msg :  this.MsgLog.getVector()) {
		   if(this.CurrUser.GetId().equals(Msg.GetSender())) {
			   if(button1.getText().equals("")) {
	    			button1.setText(Msg.GetContent());
	    			continue;
	    		}
	    		if(button2.getText().equals("")) {
	    			button2.setText(Msg.GetContent());
	    			continue;
	    		}
	    		if(button3.getText().equals("")) {
	    			button3.setText(Msg.GetContent());
	    			continue;
	    		}
	    		if(button4.getText().equals("")) {
	    			button4.setText(Msg.GetContent());
	    			continue;
	    		}
   			
   		}

	   }
   }
    //
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
    	titleCard.setBounds(115, 50, 140, 50);
    	titleCard.setEditable(false);
    	titleCard.setFont(titleFont);
    	button1.setBounds(15, 125, 325, 100);
    	button2.setBounds(15, 235, 325, 100);
    	button3.setBounds(15, 345, 325, 100);
    	button4.setBounds(15, 455, 325, 100);
    }
 
    public void addComponentsToContainer() {
    	container.add(titleCard);
    	container.add(button1);
    	container.add(button2);
    	container.add(button3);
    	container.add(button4);
    }
 
    public void addActionEvent() {
    	//button1.addActionListener(this);
    	//button2.addActionListener(this);
    	//button3.addActionListener(this);
    	//button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
 
}
 