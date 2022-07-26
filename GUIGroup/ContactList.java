import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
public class ContactList extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Contact List");
    JButton button1 = new JButton("Employee 1");
    JButton button2 = new JButton("Employee 2");
    JButton button3 = new JButton("Group 1");
    JButton button4 = new JButton("Employee 3");
    
    Font titleFont = new Font("SansSerif", Font.BOLD, 15);
 
 
    ContactList() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
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
    }
 
    public void addComponentsToContainer() {
    	container.add(titleCard);
    	container.add(button1);
    	container.add(button2);
    	container.add(button3);
    	container.add(button4);
    }
 
    public void addActionEvent() {
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	button4.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
        	JOptionPane.showMessageDialog(this, "Redirecting to Employee 1...");
        }

        if (e.getSource() == button2) {
        	JOptionPane.showMessageDialog(this, "Redirecting to Employee 2...");
        }
        
        if (e.getSource() == button3) {
        	JOptionPane.showMessageDialog(this, "Redirecting to Group 1...");
        }
        
        if (e.getSource() == button4) {
        	JOptionPane.showMessageDialog(this, "Redirecting to Employee 3...");
        }
    }
 
}
 
