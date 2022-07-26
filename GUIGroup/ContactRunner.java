import javax.swing.JFrame;

public class ContactRunner {
	public static void main(String[] a) {
		ContactList frame = new ContactList();
        frame.setTitle("Contact List");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
}
