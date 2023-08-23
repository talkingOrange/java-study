package exception;

public class ExceptionTest {
	public static void main(String[] args) {

		int a = 10;
		int b = 10 - a;

		// int result = (1 + 2 + 3) / b; //오류 발생 : 0으로 나누기

		System.out.println("Some Code1");
		try {
			System.out.println("Some Code2");
			int result = (1 + 2 + 3) / b;

			// 예외 발생 후 바로 catch 실행이 되며, code3은 출력되지 않음.
			System.out.println("Some Code3");
		} catch (ArithmeticException ex) {
			/* 예외 처리 */
			// 1. 로깅 - 파일로 남김
			System.out.println("예외발생: " + ex);

			// 2. 사과
			System.out.println("미안합니다...");

			// 3. 정상종료 - 이게 있으면 code4가 출력이 안됨.
			// System.exit(1);
			// or return;
		} finally { // 옵션. 자원정리를 위함.
			System.out.println("자원정리: file close, socket close, ...");
		}

		// 원칙적으로 가급적 여기에 코드를 적지 말아야함.
		System.out.println("Some Code4");
	}
}
