package ie.gmit.sw;

import java.util.*;

public class MainMap
{
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private ImageGenerator img;
	private Parsable toParse;
	private int maxWords;
	private String fileOrUrl;

	public MainMap(String filename, StopwordsList sl, int max, boolean isfile) throws Exception
	{
		this.maxWords = max;
		fileOrUrl = filename;
		
		if(isfile)
		{
			toParse = new FileParser(sl);
		}
		else
		{
			toParse = new UrlParser(sl);
		}
		createMap();
		System.out.println("Main Map finished...");
		img = new ImageGenerator(getMap(), maxWords);
		System.out.println("Drawing Image...");
		img.drawImage();
	}
	public void createMap() throws Exception
	{
		toParse.parse(fileOrUrl);
	}
	public Map<String, Integer> getMap()
	{
		return wordMap;
	}
}
