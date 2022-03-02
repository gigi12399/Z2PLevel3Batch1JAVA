package OOP_Assignment;

public class Ass2_Person {
	private String name;
	private String nrcno;
	private String address;
	private String phone;
	public Ass2_Person(String name, String nrcno, String address, String phone) {
		super();
		this.name = name;
		this.nrcno = nrcno;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNrcno() {
		return nrcno;
	}
	public void setNrcno(String nrcno) {
		this.nrcno = nrcno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void showInfo() {
		System.out.println("Name: " + name);
		System.out.println("NRC no: " + nrcno);
		System.out.println("Address: " + address);
		System.out.println("Phone: " + phone);
	}   
	
	public void showIdentificationInfo() {
		String[] division = {"Kachin State", "Kayah State", "Kayin State", "Chin State", "Sagaing Region", "Tanintharyi Region", "Bago Region", "Magway Region", "Mandalay Region", "Mon State", "Rakhine State", "Yangon Region", "Shan State", "Ayeyawadt Region", "Nay Pyi Taw"};
		
		String[] d = nrcno.split("/");
		String[] t = d[1].split("[(]");
		String[] n = t[1].split("[)]");
		int index = Integer.parseInt(d[0])-1;
		System.out.println("Division: " + division[index]);
		System.out.println("Township: " + t[0]);
		System.out.println("Number: " + n[1]);
	}
	
}
