package ie.gmit.sw;

import java.util.*;
import java.io.*;
import java.net.*;

public class UrlParser implements Parsable
{
	private URL url;
	private Map<String, Integer> wordMap;
	private StopwordsList s;
	
	public UrlParser(StopwordsList s)
	{
		wordMap = new HashMap<String, Integer>();
		this.s = s;
		System.out.println("Main Map finished...");
	}
	public void parse(String urlString) throws Exception
	{
		url = new URL(urlString);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer sb = new StringBuffer();
	    int j;
		// Continue reading until end of file is reached
		while((j = in.read()) != -1){
			char next = (char)j;
			
			if (next >= 'A' && next <= 'z' || next == '\'')
			{
				sb.append(next);
			}	
			else 
			{
				String word = sb.toString().toUpperCase();
				sb = new StringBuffer();
				
				// add words to map if they're not a stop word
				if (!s.hasWord(word)&& word.length() > 1) 
				{
					int frequency = 0;
					if(wordMap.containsKey(word))
					{
						frequency = wordMap.get(word);
					}
					frequency++;
					wordMap.put(word, frequency);
					//System.out.println(word + " : " + frequency);
				}
			}
		}
		in.close();			
		
	}
	public Map<String,Integer> getMap()
	{
		return wordMap;
	}
}