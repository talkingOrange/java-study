package prob3;

public class Duck extends Bird {
	
	private String birdName;
	
	//문제에서 getter, setter조건 있어서 넣음. 없어도 상관X.
	public String getBirdName() {
		return birdName;
	}

	public void setBirdName(String birdName) {
		this.birdName = birdName;
	}

	@Override
	public String toString() {
		return   "오리의 이름은 " + name + " 입니다.";
	}

	public void fly(){
		System.out.println( "오리(" + name + ")는 날지 않습니다." );
	}
	
	public void sing(){
		System.out.println(  "오리(" + name + ")가 소리내어 웁니다.");
	}

	
	
}
