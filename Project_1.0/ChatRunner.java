import javax.swing.JFrame;

public class ChatRunner {
	public static void main(String[] a) {
		Chat frame = new Chat();
        frame.setTitle("Chat");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
}