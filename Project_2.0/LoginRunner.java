import javax.swing.JFrame;

public class LoginRunner {
    public static void main(String[] a) {
    	EmployeeLogin frame = new EmployeeLogin();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
 
}