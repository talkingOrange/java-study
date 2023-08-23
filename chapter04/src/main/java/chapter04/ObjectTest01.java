package chapter04;

public class ObjectTest01 {
	public static void main(String[] args) {
		Point point = new Point(); 
	
//		Class myClass = point.getClass(); //reflection
		System.out.println(point.getClass()); //class 이름을 담는 getClass가 Object에 있다. point가 상속받아서 사용 가능
		System.out.println(point.hashCode()); // address x 
											  // reference X
											  // address 기반의 해싱값이다. String->Integer
		
		System.out.println(point.toString()); //getClass() + "@" + hashcode()
		System.out.println(point);
	}
}
