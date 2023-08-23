package chapter04;

public class ObjectTest03 {
	public static void main(String[] args) {

		// String 클래스 내부에 이미 해시코드와 equals가 오버라이드되어있다.
		String s1 = new String("Hello");
		String s2 = new String("Hello");

		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true

		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2)); // 주소기반의 해시코드, 동일성비교

		System.out.println("=======================");
		String s3 = "hello";
		String s4 = "hello";

		System.out.println(s3 == s4); // true 동일성 비교
		System.out.println(s3.equals(s4)); // true

		System.out.println(s3.hashCode() + " : " + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + " : " + System.identityHashCode(s4)); // 주소기반의 해시코드, 동일성비교

	}
}
