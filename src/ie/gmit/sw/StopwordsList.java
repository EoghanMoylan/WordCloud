package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class StopwordsList extends StopWordsSuper
{
	private HashSet<String> stopWordsSet;
	
	public StopwordsList(String filename) throws Exception
	{
		stopWordsSet = new HashSet<String>();
		try
		{
			parse(filename);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int i;
		while((i = br.read()) != -1)
		{
			char next = (char)i;
			
			if (next != '\n') sb.append(next);
			
			else 
			{
				String sWord = sb.toString().toUpperCase();
				sb = new StringBuffer();	
				stopWordsSet.add(sWord);
			}
		}
		br.close();
	}
	public boolean hasWord(String word)
	{
		boolean isThere = false;
		if(stopWordsSet.contains(word))
		{
			isThere = true;
		}
		return isThere;
	}
}
