package Day6;

import java.util.Arrays;

public class String_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "MMIT";
		String s2 = new String(new char[] {'m','m','i','t'});
		String s3 = new String("Java Programming");
		
		System.out.println("s1: " + s1.length());
		System.out.println(("s3: " + s3.length()));
		
		String lower = s2.toLowerCase();
		System.out.println("lower: " + lower);
		System.out.println("After lower case,s1: " + s1);
		
		// substring (start,end) -> start, end-1
		String substring = s3.substring(0,4); // start = 0, end = 4-1 = 3
		System.out.println(substring);
		
		// replace
		System.out.println("replace: " + s3.replace("Java", "PHP"));
		System.out.println("After replace,s3: " + s3);
		
		System.out.println("Concat: " + s3.concat(" Language!"));
		
		System.out.println("Contains: " + s3.contains("java"));
		System.out.println("startwith: " + s3.startsWith("php"));
		System.out.println("endwith: " + s3.endsWith("Programming"));
		
		System.out.println("location of 'a': " + s3.indexOf("a"));
		System.out.println("location of '/': " + s3.indexOf("/"));
		System.out.println("location of 'a': " + s3.lastIndexOf("a"));
		
		// split
		String[] arr = s3.split(" ");
		System.out.println(Arrays.toString(arr));
		
		char[] s1Arr = s1.toCharArray();
		System.out.println(Arrays.toString(s1Arr));
		
		String str = String.valueOf(s1Arr);
		System.out.println("str: " + str);
		
		System.out.println("int: " + String.valueOf(1000));
		System.out.println("bool: " + String.valueOf(false));
	} 

}
