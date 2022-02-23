package String_Assignment;

public class String_Ass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String paragraph = "NLP techniques are becoming widely popular scientific research areas as well as Information Technology industry. Language technology together with Information Technology can enhance the lives of people with different capabilities. This system implements voice command mobile phone dialer application. The strength of the system is that it can make phone call to the contact name written in either English scripts or Myanmar scripts.";
		int words = paragraph.split(" ").length;
		int sentences = paragraph.split("[.]").length;
		System.out.println("For this paragraph,");
		System.out.println("Number of sentences: " + sentences);
		System.out.println("Total words: " + words);
	}

}
