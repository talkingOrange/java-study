package prob04;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
	    int length = str.length();
	    char[] reverseArray = new char[length];
	    
	    for (int i = 0; i < length; i++) {
	        reverseArray[i] = str.charAt(length - i - 1);
	    }
	    
	    return reverseArray;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}