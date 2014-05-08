package shapes.model.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import shapes.model.*;

public class CalculateAreaTest {	

	@Test
	public void sixFor2X3Rectangle() {
		Rectangle r = new Rectangle();
		r.setHeight(2);
		r.setWidth(3);
		assertEquals(6, AreaCalculator.calculateArea(r));
	}
	
	@Test
	public void nineFor3X3Square() {
		Square s = new Square();
		s.setHeight(3);
		assertEquals(9, AreaCalculator.calculateArea(s));
	}
	
	@Test
	public void twentyFor4X5RectangleFromSquare() {
		Rectangle r = new Square();
		r.setHeight(4);
		r.setWidth(5);
		assertEquals(20, AreaCalculator.calculateArea(r));
	}

}
