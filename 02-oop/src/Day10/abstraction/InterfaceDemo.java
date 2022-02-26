package Day10.abstraction;

public class InterfaceDemo {

	public static void main(String[] args) {
		Button btn1 = new Button("btn-LogIn");
		Button btn2 = new Button("btn-LogOut");
		
		btn1.display();
		btn1.onClick();
		btn1.onDoubleClick();
		
		btn2.display();
		btn2.onClick();
		btn2.onDoubleClick();
	}

}
