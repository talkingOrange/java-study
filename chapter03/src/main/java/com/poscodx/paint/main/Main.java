package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;


public class Main {
	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		
		Point point2 = new Point(20,30);
		
		//drawPoint(point1);
		draw(point1);
		//drawPoint(point2);
		draw(point2);
		//point1.disappear();
		point1.show(false);
		
		Point point3 = new ColorPoint(); //업캐스팅 (암시)
		point3.setX(30);
		point3.setY(30);
		
		//ColorPoint p = (ColorPoint)point3; //다운캐스팅 (명시)
		((ColorPoint)point3).setColor("red"); //다운캐스팅
		//drawPoint(point3);
		draw(point3);
		
		Rect rect = new Rect();
//		drawRect(rect);
		//drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
		//drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
		//drawShape(circle);
		draw(circle);
		
		draw(new GraphicText("Hello world"));
		
		//instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);
		
		//오류: 연산자 우측항이 클래스인 경우, 
		//     레퍼런스 하고 있는 class 타이브이 hierachy상의 하위와 상위만 instanceof 연산자를 사용할 수 있다.
		// System.out.println(circle instanceof Rect);
		
		//연산자 우측항이 인터페이스인 경우, 
		// hierachy 상관없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable); //false 출력
	}
	/**
	private static void drawShape(Shape shape) {
		shape.draw();
		
	}
	public static void drawPoint(Point point) {
		point.show();
	}
	
	public static void drawRect(Rect rect) {
		rect.draw();
	}
	**/
	public static void draw(Drawable drawable) {
		drawable.draw();
	}

}
