package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FileParser implements Parsable
{
	private Map<String, Integer> wordMap;
	private StopwordsList s;
	
	public FileParser(StopwordsList s)
	{
		wordMap = new HashMap<String, Integer>();
		this.s = s;
	}
	public void parse(String filename) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		StringBuffer sb = new StringBuffer();
		
		int j;
		// Continue reading until end of file is reached
		while((j = br.read()) != -1){
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
		br.close();		
	}
	public Map<String,Integer> returnMap()
	{
		return wordMap;
	}
}
