package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle() {
		// TODO Auto-generated constructor stub
	}

	public RectTriangle(double width, double height) {
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
		return "RectTriangle [width=" + width + ", height=" + height + "]";
	}

	@Override
	double getArea() {
		return width * height * 0.5;
	}

	@Override
	double getPerimeter() {
		return (width + height) + Math.sqrt(width * width + height * height);
	}

}
