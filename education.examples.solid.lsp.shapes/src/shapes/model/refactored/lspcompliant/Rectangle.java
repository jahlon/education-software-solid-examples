package shapes.model.refactored.lspcompliant;

public class Rectangle extends Shape {
	protected int width;
	protected int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int area() {
		return width * height;
	}
}
