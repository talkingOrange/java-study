package prob6;

public class Rectangle extends Shape implements Resizable{
	private double width;
	private double height;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	
	public double getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	@Override
	double getArea() {
		return width*height;
	}
	@Override
	double getPerimeter() {
		return (width+height) * 2 ;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height *s;
	}
	
}
