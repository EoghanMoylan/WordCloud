package ie.gmit.sw;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

public class ImageGenerator
{
	private Map<String, Integer> map;
	private int maxWords;
	private RectangleList rectList;
	private Graphics2D graphics;
	private FontHandler fontHandler;
	private int xposition = 500;
	private int yposition = 500 ;
	private int i;
	public ImageGenerator(Map<String, Integer> map, int max) throws Exception
	{
		this.maxWords = max;
		this.map = map;
		fontHandler = new FontHandler();
		rectList = new RectangleList();
		i =0;
	}
	public void drawImage() throws Exception
	{
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);
		graphics = (Graphics2D)image.getGraphics();
		i = 0;
		
		for(String word : map.keySet())
		{  
			int direction =0;
			
			if(direction == 3)
			{
				direction = 0;
			}
			else
			{
				direction++;
			}
			if(map.get(word) <= 1 == false)
			{
				
				System.out.println(map.get(word));
				
				fontHandler.setSize(map.get(word) + 15);
				fontHandler.setFont();
				fontHandler.setColour();
	
				drawWord(fontHandler.getFont(), fontHandler.getColour(),word, direction);
			}
			if(i == maxWords)
			{
				break;
			}
			i++;
		}
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
	}
	private void changeLocation(Rectangle2D r, int direction)
	{
		switch(direction)
		{
			case 0:
				if(!(yposition + r.getHeight() > 1000))
					yposition+=3;
				break;
				
			case 1:
				if(!(xposition + r.getWidth() > 1000))
					xposition+=3;
				break;
				
			case 2:
				if(!(yposition - r.getHeight() < 0))
					yposition-=3;
				break;
				
			case 3:
				if(!(xposition - r.getWidth() < 0))
					xposition-=3;
				break;			
		}
	}
	private Rectangle getBoundaries(Graphics2D g, String word, int x, int y)
	{
		FontRenderContext frc = g.getFontRenderContext();
		GlyphVector gv = g.getFont().createGlyphVector(frc, word);
		return gv.getPixelBounds(null, x, y);
	}
	private void drawWord(Font font, Color color, String word, int direction)
	{
		
		Rectangle2D rect ;
		
		graphics.setFont(font);
		graphics.setColor(color);
		
		rect = getBoundaries(graphics, word, xposition, yposition); 
        	
		while(rectList.checkOverLap(rect))
		{
			changeLocation(rect, direction);
			rect = getBoundaries(graphics, word, xposition, yposition); 
		}
		
		rectList.add(rect);
		graphics.drawString(word, xposition, yposition);
	}
}
