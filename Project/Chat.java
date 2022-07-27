import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Font;
 
public class Chat extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Chat");
    JTextArea button1 = new JTextArea("");
    JButton button2 = new JButton("Return");
    JTextField button3 = new JTextField("");
    JButton button4 = new JButton("Send");
    
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
	   Boolean EmptyLog = true;
	   for(Message Msg :  this.MsgLog.getVector()) {
		   if(this.CurrUser.GetId().equals(Msg.GetReciever()) && this.OtherUser.GetId().equals(Msg.GetSender())) {
			   //button1.append(Msg.GetContent());
			  // button1.append();
			   button1.append("\n" + Msg.GetSender() + "  [" + Msg.GetTimeStamp() + "] : " + Msg.GetContent());	 
			   EmptyLog = false;
		   }
		   if(this.CurrUser.GetId().equals(Msg.GetSender()) && this.OtherUser.GetId().equals(Msg.GetReciever())) {
			   button1.append("\n" + Msg.GetSender() + "(Self)  [" + Msg.GetTimeStamp() + "] : " + Msg.GetContent());	
			   EmptyLog = false;
		   }
	   }
	   if(EmptyLog) {
		   button1.append("THERE ARE NO MESSAGES BETWEEN USER");
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
    	//MessageLog
    	button1.setBounds(15, 125, 325, 300);
    	//Return
    	button2.setBounds(15, 550, 325, 40);
    	//Txt
    	button3.setBounds(15, 445, 325, 50);
    	//Send
    	button4.setBounds(15, 500, 325, 40);
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
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button2){
        	
        	
        	ContactList frame = new ContactList();
        	frame.SetUser(CurrUser);
        	frame.SetButtons();
        	
            frame.setTitle("Contact List");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);
        }
        //Send
        if(e.getSource() == button4) {
        	String Txt = button3.getText();
        	
        	try {
				Socket theSocket = new Socket("localhost", 5001);
				Message New = new Message(this.CurrUser.GetId(),this.OtherUser.GetId(), Txt, null, null);
				New.SetTime();
				
				OutputStream buffer = new BufferedOutputStream(theSocket.getOutputStream());
				
				ObjectOutputStream out = new ObjectOutputStream(buffer);
//				JOptionPane.showMessageDialog(this, New);
				out.writeObject(New);
				out.flush();
				
				InputStream buffered = new BufferedInputStream(theSocket.getInputStream());	
				ObjectInputStream input = new ObjectInputStream(buffered);
				Message Temp  = (Message)input.readObject();
				this.MsgLog.addMessage(Temp);
				this.MsgLog.SaveMsgLog();
				//JOptionPane.showMessageDialog(this, this.MsgLog.getVector());
				//reset text box
	        	button1.setText(null);
	        	button3.setText(null);
	        	SetText();
	        	
	        
	        	
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     
        }
    }
 
}
 