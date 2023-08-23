package com.poscodx.paint.shape;

public class Triangle extends Shape {

	private int x1, x2, x3;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	@Override
	public void draw() {
		System.out.println("삼각형을 그렸습니다.");
	}

}
