import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
public class Chat extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Chat with [Name]");
    JButton button1 = new JButton("");
    JButton button2 = new JButton("");
    JButton button3 = new JButton("");
    JButton button4 = new JButton("");
    
    Font titleFont = new Font("SansSerif", Font.BOLD, 15);
 
 
    Chat() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
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
 
