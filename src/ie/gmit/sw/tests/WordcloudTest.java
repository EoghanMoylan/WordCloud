package ie.gmit.sw.tests;

import org.junit.*;
import ie.gmit.sw.*;

public class WordcloudTest 
{
	private MainMap testMap;
	private StopwordsList stopwords;
	@Before
	@After
	public void destroyMap()
	{
		testMap = null;
	}
	@Test
	public void validUrl() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("http://www.gmit.ie/", stopwords, false);
	}
	@Test
	public void inValidUrl() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("http://ww.gmit.e/", stopwords, false);
	}
	@Test 
	public void validFile() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("./Tolstoy.txt", stopwords, true);
	}
	@Test
	public void inValidFile() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("./Tstoy.txt", stopwords, true);
	}
	@Test
	public void invalidStopwords() throws Exception
	{
		stopwords = new StopwordsList("stopds.txt");
	}
	@Test
	public void validImageGenerator() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("./Tolstoy.txt", stopwords, true);
		ImageGenerator img = new ImageGenerator(testMap.getMap(), 80);
	}
	@Test
	public void invalidImageGenerator() throws Exception
	{
		stopwords = new StopwordsList("stopwords.txt");
		testMap = new MainMap("./Tolstoy.txt", stopwords, true);
		ImageGenerator img = new ImageGenerator(testMap.getMap(), 80);
	}
}