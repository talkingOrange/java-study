package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			if ((i%10) % 3 ==0 ) {
				if (i > 10 && (i / 10) % 3 == 0 && (i%10)!=0) {
					System.out.println(i + " ¦¦");
				}else {	System.out.println(i + " ¦");}
			}
		}
	}
}
