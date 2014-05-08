package shapes.model.refactored.noinherit;

public class Square extends Shape {
	private int sideLenght;

	public int getSideLenght() {
		return sideLenght;
	}

	public void setSideLenght(int sideLenght) {
		this.sideLenght = sideLenght;
	}
	
	public int area() {
		return sideLenght * sideLenght;
	}
}
