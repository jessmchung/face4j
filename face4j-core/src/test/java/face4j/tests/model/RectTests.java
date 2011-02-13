package face4j.tests.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import face4j.model.Point;
import face4j.model.Rect;

public class RectTests
{

	@Test
	public void containsRect()
	{
		Rect r = new Rect();
		
		r.bottom = 1;
		r.top	 = 4;
		r.right  = 5;
		r.left   = 1;
		
		assertTrue(r.contains(2, 3));
		assertFalse(r.contains(6, 3));
	}
	
	@Test 
	public void containsPoint()
	{
		Point p_in  = new Point(5,5);
		Point p_out = new Point(5,7);
		
		Rect r  = new Rect(1,6,7,1);
		
		assertTrue(r.contains(p_in));
		assertFalse(r.contains(p_out));
	}
	
	@Test
	public void constructFormPoint_W_H()
	{
		Point center = new Point(5,5);
		float width = 5, height  = 5;
		
		Rect r = new Rect(center, width, height);
		
		assertTrue(r.contains(new Point(5,5)));
	}
}