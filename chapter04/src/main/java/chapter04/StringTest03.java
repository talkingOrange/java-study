package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
//		String s1 = "Hello" + "World" + "Java" + 17;
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World");
		sb.append("Java");
		sb.append(17);
//		String.valueOf(17) ; return (String) 17
		
//		StringBuffer("Hello").append("World").append("Java")+append(17); 메소드 체인 가능
		
		String s1 = sb.toString();
		
		String s2 = new StringBuffer("Hello").append("World").append("Java").append(17).toString();

		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("==========================");
		
		String s3 = "";
		for(int i =0; i<1000000; i++) {
//			s3 += i; 쓰지말자!
//			s3 = new StringBuffer(s3).append(i).toString(); 쓰지말자!
		}
		StringBuffer sb2 = new StringBuffer("");
		for(int i =0 ; i < 1000000; i++) {
			sb.append(i);
		}
		String s4 = sb.toString(); 
		
//		System.out.println(s4); //굉장히 빠름. StringBuffer는 String의 + 를 대신하여 사용
		
		
		// String method들...
		String s5 = "aBcABCabc";
		System.out.println(s5.length());
		System.out.println(s5.charAt(2));
		System.out.println(s5.indexOf("abc"));
		System.out.println(s5.indexOf("abc", 7)); //abc를 7번째부터 찾음.
		System.out.println(s5.substring(3)); //3번째~끝까지 뽑기.
		System.out.println(s5.substring(3, 5)); //3번째~n-1번째(4번째)까지 뽑기.
		System.out.println(s5.toLowerCase());
		
		String s6 = " ab  cd ";
		String s7 = "efg,hij,klm,nop,qrs";
		
		String s8 = s6.concat(s7);
		System.out.println(s8);
		
		System.out.println(s6.trim()); //양쪽의 공백을 지움.
		System.out.println(s6.replaceAll(" ","")); //모든 공백을 지움. " " -> ""
		
		String[] tokens = s7.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s7.split(" ");
		for(String s: tokens2) {
			System.out.println(s);
		}
		
		
	}
}
