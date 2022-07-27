import java.io.IOException;
import java.net.Socket;
public class Logout {
	public void closeSocket(Socket socket) throws IOException {
		Socket theSocket = socket;
		System.out.println("Logging out in progress ...");
		theSocket.close();
		System.exit(0);
	}
}
