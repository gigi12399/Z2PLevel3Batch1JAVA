package Day6;

public class StringBuffer_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer("Java Programming");
		
		System.out.println("Original: " + buffer);
		buffer.append(" Language");
		System.out.println("Buffer: " + buffer);
		
		buffer.insert(4, " is a");
		System.out.println("Insert: " + buffer);
		
		buffer.replace(0, 4, "PHP");
		System.out.println("Replace: " + buffer);
		
		System.out.println("Length: " + buffer.length());
		
		System.out.println("Indexof: " + buffer.lastIndexOf("Language"));
		
		System.out.println("substring: " + buffer.substring(4));
		System.out.println("After substring: " + buffer);
		
		buffer.delete(0, 4);
		System.out.println("Delete: " + buffer);
	}

}
