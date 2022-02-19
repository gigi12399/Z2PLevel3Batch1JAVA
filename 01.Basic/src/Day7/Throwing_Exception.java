package Day7;

public class Throwing_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] numbers = {100,200,300};
			int index = 5;
			if(index >= numbers.length)
				throw new ArrayIndexOutOfBoundsException("Out of Range");
				
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.err.println(e.getMessage());
		}
	}

}
