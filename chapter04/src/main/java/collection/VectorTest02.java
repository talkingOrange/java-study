package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {
	
	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		// 순회01
		for(int i= 0; i<list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		// 삭제
		list.remove(2);
		
		// 순회02
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		// 순회03
		for(String s : list) {
			System.out.println(s);
		}
		
		
	}

}
