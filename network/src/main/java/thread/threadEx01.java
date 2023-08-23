package thread;

public class threadEx01 {
	public static void main(String[] args) {
		//for(int i = 0 ; i <10; i++) {
		//	System.out.print(i);
		//}
		
		//Thread를 쓰면, 자리 선점하는데 시간이 걸려서 밀린다. 
		//출력 결과 : abc0123456789defghijklmnopqrstuvwxyz
		new DigitalThread().start();
		
		for(char c= 'a'; c<= 'z'; c++) {
			System.out.print(c);
			
			try {
				//sleep을 통해 이 두 가지 for문을 섞어줌.
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
