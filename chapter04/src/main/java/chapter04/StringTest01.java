package chapter04;

public class StringTest01 {
	public static void main(String[] args) {
		// c:\temp -> 디렉토리 표시의 표준은 /인데, 윈도우만 \으로 되고, linux에서 /이렇게 해놓으면 윈도우가 알아서 해줌.
//		System.out.println("c:\temp"); //c:	emp > \t: tab 
		System.out.println("c:\\temp"); //이스케이프 \\ -> \
		
		System.out.println("\"Hello\"");
		
		// control character
		// \t : tab
		// \r : carriage return 앞으로 당기는 것.
		// \n : newline
		// \b : bell
		
		System.out.println();
		
		char c = '\'';
		System.out.println(c);
		
		String path1 = "D:\\poscodx2023\\Dowork";
		String path2 = "D:/poscodx2023/Dowork";
	}
}
