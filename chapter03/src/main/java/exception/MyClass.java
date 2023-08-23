package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1.....");
		System.out.println("some code2.....");

		if( 3 -3 == 0) {
			throw new MyException();
		}
		
		if (1 - 1 == 0) {
			throw new IOException(); // 내가 메소드를 구현했는데, throw하나 있으면 상단에 throws 있어야함.
		}

		System.out.println("some code3....."); // exception으로 여기 밑에 안와서 오류가 남. 그럼 상단을 if처리하면 됨.
		System.out.println("some code4.....");

	}
}
