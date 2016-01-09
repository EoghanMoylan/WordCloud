package ie.gmit.sw;

import java.util.*;

public class MainMap
{
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();
	private Parsable toParse;
	private String fileOrUrl;

	public MainMap(String filename, StopwordsList sl, boolean isfile) throws Exception
	{
		fileOrUrl = filename;
		//tries to parse file through either the url or file parser
		try
		{
			if(isfile)
			{
				toParse = new FileParser(sl);
				System.out.println("Main file parsed...");
			}
			else
			{
				toParse = new UrlParser(sl);
				System.out.println("URL parsed...");
			}
			createMap();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void createMap() throws Exception
	{
		toParse.parse(fileOrUrl);
		//populates map with parsed data from the parser
		wordMap = toParse.getMap();
	}
	public Map<String, Integer> getMap()
	{
		return wordMap;
	}
}
