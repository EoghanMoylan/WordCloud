package ie.gmit.sw;

import java.awt.geom.*;
import java.util.*;

public class RectangleList 
{
	private Set<Rectangle2D> rectList;
	
	public RectangleList()
	{
		//creates a list of rectangles
		rectList = new HashSet<Rectangle2D>();
	}
	public void add (Rectangle2D rect)
	{
		//adds new rectangles to list
		rectList.add(rect);
	}
	public void remove(Rectangle2D rect)
	{
		//removes rectangles from the list
		rectList.remove(rect);
	}
	public boolean checkOverLap(Rectangle2D rect)
	{
		boolean overlapping = false;
		//runs through the entire list and checks to see
		//if the new rectangle is overlapping with any 
		//other rectangles. If it is overlapping will return true
		for(Rectangle2D rectOne : rectList)
		{
			overlapping = (rectOne.intersects(rect));
			
			if(overlapping)
			{
				break;
			}
		}
		//System.out.println(overlapping);
		return overlapping; 
	}
}