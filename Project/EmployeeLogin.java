import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
 
public class EmployeeLogin extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    JTextField titleCard = new JTextField("Employee Login");
    JLabel userCard = new JLabel("Username");
    JLabel passwordCard = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    Font titleFont = new Font("SansSerif", Font.BOLD, 15);
 
 
    EmployeeLogin() {
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
    	userCard.setBounds(50, 150, 100, 30);
    	passwordCard.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
 
 
    }
 
    public void addComponentsToContainer() {
    	container.add(titleCard);
        container.add(userCard);
        container.add(passwordCard);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            // Creates TUser Object And Current Valid Users
            User Temp = new User();
            User Find = new User();
            UserVerify TempUserLog = new UserVerify();
            TempUserLog.LoadUserFile();
            Temp.SetID(userText);
            Temp.SetPass(pwdText);
            // Checks User Is In UserLog
            Find = TempUserLog.SearchUser(Temp);
            
            
            
            
            
            if (Find!=null) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                
                // If True Moves Onto Contact List
        		ContactList frame = new ContactList();
                // Transfer User To Contact
                frame.SetUser(Find);
                frame.SetButtons();
                //
                frame.setTitle("Contact List");
                frame.setVisible(true);
                frame.setBounds(10, 10, 370, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                
                this.setVisible(false);
            } 
            else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
 
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
 
 
        }
    }
 
}
 