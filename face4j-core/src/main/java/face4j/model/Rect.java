package face4j.model;

public class Rect
{	
	public float top;
	
	public float bottom;
	
	public float left;
	
	public float right;
	
	public Rect () {}
	
	public Rect (Rect rect)
	{
		this (rect.left, rect.top, rect.right, rect.bottom);
	}
	
	public Rect (Point center, float width, float height)
	{
		this (
				center.x - (width/2),
				center.y + (height/2),
				center.x + (width/2),
				center.y - (height/2)
				);
	}
	
	public Rect (float left, float top, float right, float bottom)
	{
		this.top    = top;
		this.bottom = bottom;
		this.left   = left;
		this.right  = right;
	}
	
	public boolean contains (Point p)
	{
		return contains(p.x, p.y);
	}
	
	public boolean contains (float x, float y)
	{
		return 
			bottom <= y &&
			right  >= x &&
			left   <= x && 
			top    >= y; 
	}
	
	public boolean contains (Rect r)
	{
		return contains (r.top, r.bottom, r.left, r.right);
	}
	
	public boolean contains (float left, float top, float right, float bottom)
	{
		return 
			this.bottom <= bottom &&
			this.right  >= right  &&
			this.left   <= left   &&
			this.top    >= top;
			
	}

	@Override
	public int hashCode ()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(bottom);
		result = prime * result + Float.floatToIntBits(left);
		result = prime * result + Float.floatToIntBits(right);
		result = prime * result + Float.floatToIntBits(top);
		return result;
	}

	@Override
	public boolean equals (Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Rect other = (Rect) obj;
		if (Float.floatToIntBits(bottom) != Float.floatToIntBits(other.bottom))
		{
			return false;
		}
		if (Float.floatToIntBits(left) != Float.floatToIntBits(other.left))
		{
			return false;
		}
		if (Float.floatToIntBits(right) != Float.floatToIntBits(other.right))
		{
			return false;
		}
		if (Float.floatToIntBits(top) != Float.floatToIntBits(other.top))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString ()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Rect [bottom=").append(bottom)
			   .append(", left=").append(left)
			   .append(", right=").append(right)
			   .append(", top=").append(top).append("]");
		return builder.toString();
	}
	
}