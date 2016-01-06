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
	private RectangleList rectList = new RectangleList();
	
	public ImageGenerator(Map<String, Integer> map, int max) throws Exception
	{
		this.maxWords = max;
		this.map = map;
	}
	public void drawImage() throws Exception
	{
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics = (Graphics2D)image.getGraphics();
		int i = 0;
		int fontSize = 10;
		int xpoition = 500;
		int yposition = 500 ;
		
		for(String word : map.keySet())
		{  
			if(map.get(word) <= 1 == false)
			{
				i++;
				System.out.println(map.get(word));
				
				Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize + map.get(word));
				if(map.get(word) <= 5)
				{
					graphics.setColor(Color.red);
				}
				else if(map.get(word) > 5 && map.get(word) <= 20)
				{
					graphics.setColor(Color.green);
				}
				else if(map.get(word) > 20 && map.get(word) <= 50)
				{
					graphics.setColor(Color.ORANGE);
				}
				else if(map.get(word) > 50 && map.get(word) <= 70)
				{
					graphics.setColor(Color.blue);
				}
				else
				{
					graphics.setColor(Color.yellow);
				}
				
				Rectangle2D rect = getBoundaries(graphics, word, xpoition, yposition);
	
				do
				{
					xpoition += 10;
				    yposition -= 10;
				    
				}while(rectList.checkOverLap(rect));
				System.out.println("Here" + " " + i);
				rectList.add(rect);
				
				graphics.setFont(font);
				graphics.drawString(word, xpoition, yposition);
				
				if(i == maxWords)
				{
					break;
				}
			}
		}
		graphics.dispose();
		ImageIO.write(image, "png", new File("image.png"));
	}
	private Rectangle getBoundaries(Graphics2D g, String word, int x, int y)
	{
		FontRenderContext frc = g.getFontRenderContext();
		GlyphVector gv = g.getFont().createGlyphVector(frc, word);
		return gv.getPixelBounds(null, x, y);
	}
}
