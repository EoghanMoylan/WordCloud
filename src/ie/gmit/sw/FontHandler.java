package ie.gmit.sw;

import java.awt.*;
import java.util.Random;

public class FontHandler 
{
	private Font font;
	private int fontSize;
	private Color fontColour;
	public void setFont(String name, int style, int size)
	{
		font = new Font(name, style, size);
	}

	public void setFont() 
	{
		setFont(randomFont(), Font.PLAIN, getSize());		
	}
	public void setColour()
	{
		fontColour = getRandomColor();
	}
	public Color getColour()
	{
		return fontColour;
	}
	public void setSize(int size)
	{
		fontSize = (int)(size);
	}
	
	public int getSize()
	{
		return fontSize;
	}
	
	public Font getFont()
	{
		return font;
	}

	private Color getRandomColor()
	{		
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}
	
	private String randomFont()
	{
		Random random = new Random();
		
		switch(random.nextInt(3))
		{
		case 0:
			return Font.SANS_SERIF;
			
		case 1:
			return Font.MONOSPACED;
			
		case 2:
			return Font.SERIF;
			
		default:
			return Font.SANS_SERIF;
		}		
	}
}
