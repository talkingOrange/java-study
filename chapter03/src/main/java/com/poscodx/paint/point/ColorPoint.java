package com.poscodx.paint.point;

public class ColorPoint extends Point{

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//annotation = marking = tag : 컴파일러가 오류인지 확인해줌. + 개발자가 이해가 쉽다.
	@Override
	public void show() {
		System.out.println("점[x=" + x + ",y=" + y + ",color=" + color + "]을 그렸습니다.");
	}
	
	

}
