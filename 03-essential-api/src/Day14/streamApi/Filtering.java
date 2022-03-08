package Day14.streamApi;

import java.util.List;

public class Filtering {
	public static void main(String[] args) {
//		List<Users> user = List.of(
//				new user("Kyaw Kyaw",9800,"Yangon"),
//				new user("Aung Aung",6000,"Mandalay"),
//				new user("Mg Mg",10000,"Mandalay"),
//				new user("Yuri",6000,"Yangon"),
//				new user("Jeon",7800,"Monywa")
//				);
				
	}
}

class Users{
	private String name;
	private String role;
	
	public Users() {
	
	}

	public Users(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean IsStaff() {
		return this.role.equalsIgnoreCase("staff");
	}
	
}
