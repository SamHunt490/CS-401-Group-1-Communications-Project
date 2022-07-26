import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class GroupList {
	private String GroupName;
	private static String filename = "GroupListDataFile.txt";
	private Vector <String> Grouplist;
	
	public GroupList() {
		this.Grouplist = new Vector <String>();
		this.GroupName = "Undefined";
	}
	public String GetGroupName() {
		return this.GroupName;
	}
	public String GetFileName() {
		return filename;
	}
	public void SetGroupName(String name) {
		this.GroupName = name;
	}
	public void SetFileName(String file) {
		filename = file;
	}
	public void AddToGroup(String Id) {
		this.Grouplist.add(Id);
	}
	public Vector<String> GetGroup(){
		return this.Grouplist;
	}
	public void LoadGroup() {
		File myfile = new File(filename);
		try {
			System.out.println("Here2");
			Scanner sc = new Scanner(myfile);
			sc.useDelimiter(",");
			String TempGroupname, GroupMember;
			while(sc.hasNext()) {
				TempGroupname = sc.next();
				GroupMember = sc.nextLine();
				GroupMember = GroupMember.substring(1);
				System.out.println(TempGroupname + " - " + GroupMember);
				if(this.GroupName.equals(TempGroupname)) {
					this.Grouplist.add(GroupMember);
				}
				
			}
			sc.close();

		}
		catch(Exception e){
			return;
		}
	}
	
}
