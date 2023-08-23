package exception;

import java.io.IOException;

public class MyClassTest {
	public static void main(String[] args) {
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
//		} catch (IOException e) {
//			e.printStackTrace(); //예외처리로 별로 할 게 없으면, 이 문장이라도 적어두기.
//		} catch (MyException e) {
//			e.printStackTrace();
//		}
		} catch (Exception e) { // 모든 exception을 여기서 받을게.
			e.printStackTrace();
		}
	}
}
