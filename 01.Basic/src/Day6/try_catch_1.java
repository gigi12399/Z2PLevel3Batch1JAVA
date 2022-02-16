package Day6;

public class try_catch_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] num = {100,200,300};
			System.out.println(num[4]);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Outside try-catch!");
	}

}
