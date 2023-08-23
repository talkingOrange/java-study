package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		
		s.add("또치"); //자료구조는 무조건 동질성 비교이다. 같은 것을 넣지 않음.
		s.add(s1); //자료구조는 무조건 동질성 비교이다. 같은 것을 넣지 않음.
		s.add(s2); //값 기반임. 주소는 XXX
		
		System.out.println(s.size());
		System.out.println(s.contains(s2));
		System.out.println(s.size());
		
		// 순회
		for(String str : s) {
			System.out.println(str);
		}
		
	}
}
