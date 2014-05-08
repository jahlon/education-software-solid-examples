package shapes.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import shapes.model.refactored.lspcompliant.*;

public class ShapeLSPCompliantTest {


	@Test
	public void sixFor2X3Rectangle() {
		Rectangle r = new Rectangle();
		r.setHeight(2);
		r.setWidth(3);
		assertEquals(6, r.area());
	}
	
	@Test
	public void nineFor3X3Square() {
		Square s = new Square();
		s.setSideLenght(3);
		assertEquals(9, s.area());
	}

	@Test
	public void twentyFor4X5RectangleAndNineFor3X3SquareFromShape() {
		Rectangle r = new Rectangle();
		r.setHeight(4);
		r.setWidth(5);
		
		Square s = new Square();
		s.setSideLenght(3);
		
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(r);
		shapes.add(s);
		
		List<Integer> areas = new ArrayList<Integer>();
		for (Shape shape : shapes) {
			areas.add(shape.area());
		}
		assertEquals(20, areas.get(0).intValue());
		assertEquals(9, areas.get(1).intValue());
	}

}
