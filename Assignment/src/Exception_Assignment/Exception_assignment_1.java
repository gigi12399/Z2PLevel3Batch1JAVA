package Exception_Assignment;



public class Exception_assignment_1 {
	static int i_arr;
	static int sum = 0;
	static int min;
	static int max;
	static int stringToInteger(String[] s_arr) {
		for(var s : s_arr) {
			i_arr = Integer.parseInt(s);
			sum = sum + i_arr;
		}
		min = Integer.parseInt(s_arr[0]);
		max = Integer.parseInt((s_arr[0]));
		for(int i = 1; i < s_arr.length; i++) {
			
			if(min > Integer.parseInt(s_arr[i])) {
				min = Integer.parseInt(s_arr[i]);
			}
			if(max < Integer.parseInt(s_arr[i])) {
				max = Integer.parseInt(s_arr[i]);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s_arr = { "11", "abc", "3", "5"};
		try {
			int total = stringToInteger(s_arr);
			System.out.println("Total: " + total);
			System.out.println("Maximum: " + max);
			System.out.println("Minimun: " + min);
			System.out.println("Average; " + (float)total/s_arr.length);

		}catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

	

}
