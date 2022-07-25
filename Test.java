import java.io.*;

public class Test {
	public static void main(String[] agrs) {
		// TEST FOR MESSAGE OBJ
		Message Test = new Message();
		System.out.print(Test);
		System.out.println("---------------------------");
		// TEST FOR MESSAGE OBJ WITH PARAMETERS
		MessageType Type = MessageType.TEXTMESSAGE;
		Message Test2 = new Message("Self1", "Other1", "BLAH1", "7.22.2022", Type);
		Message Test3 = new Message("Self2", "Other2", "BLAH2", "7.22.2022", Type);
		Message Test4 = new Message("Self3", "Other3", "BLAH3", "7.22.2022", Type);
		System.out.print(Test2);
		System.out.println("---------------------------");
		// TEST FOR MESSAGELOG 
		MessageLog Test5 = new MessageLog();
		Test5.addMessage(Test2);
		Test5.addMessage(Test3);
		Test5.addMessage(Test4);
		System.out.print(Test5.getVector());
		System.out.println("\n---------------------------");
		Test5.LoadMsgFile("messageLog.txt");
		System.out.println(Test5.getVector());
		System.out.println("\n---------------------------");
		//System.out.print(Test5.SearchMsgLog("Me", "They"));
		Message Test6 = new Message("Self6", "Other6", "BLAH3", "7.22.2022", Type);
		Test5.addMessage(Test6);
		Test5.SaveMsgLog();
		
	}
		
}

