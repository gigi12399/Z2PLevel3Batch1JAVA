package Day1;

public class Block_Test {
	static final int MIN_LENGTH;
	String phone;
	
	{// instance block
		System.out.println("This is instance block!");
		phone = "Invalid number";
	}
	
	static{// static block
		System.out.println("This is static block!");
		MIN_LENGTH = 9;
	}
	
	public Block_Test(String phone) {
		System.out.println("This is constructor block!");
		if(phone.length() >= MIN_LENGTH)
			this.phone = phone;
	}
	public static void main(String[] args) {
		Block_Test test = new Block_Test("098765432");
		System.out.println("Phone: " + test.phone);
		
		Block_Test test1 = new Block_Test("123");
	}
}
