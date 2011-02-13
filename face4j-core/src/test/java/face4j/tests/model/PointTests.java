package face4j.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import face4j.model.Point;

public class PointTests
{
	
	@Test
	public void testNegate()
	{
		Point p = new Point(3, 8);
		p.negate();
		assertEquals(p, new Point(-3, -8));
	}
	
	@Test
	public void equals()
	{
		Point p = new Point(1,2);
		assertTrue(p.equals(1, 2));
	}
	
	@Test
	public void otherEquals()
	{
		Point p1 = new Point(1.1f, 2);
		Point p2 = new Point(1, 3);
		Point p3 = new Point(p1);
		assertTrue(p1.equals(p3));
		assertFalse(p1.equals(p2));
	}
	
	@Test
	public void offSet()
	{
		Point p = new Point(1.4f, 14.2f);
		p.offset(0.6f, 0.8f);
		
		assertTrue(p.x == 2 && p.y == 15);
	}
}
