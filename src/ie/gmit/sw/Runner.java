package ie.gmit.sw;

public class Runner
{
	private static boolean isFile;
	private static String fileToParse;
	private static String stopwords;
	public static void main(String[] args) throws Exception 
	{
		//take input from command line when running jar file
		//so as not to create dependencies
		fileToParse = args[0];
		stopwords = args[1];
		
		if(args[2].equalsIgnoreCase("false"))
		{
			isFile = false;
		}
		else
		{
			isFile = true;
		}
		//create image generator, stopwords list and the main map
		ImageGenerator img;
		StopwordsList stopWords = new StopwordsList(stopwords);
		MainMap map = new MainMap(fileToParse, stopWords,isFile);
		
		img = new ImageGenerator(map.getMap(), 200);
		System.out.println("Drawing Image...");
		img.drawImage();
		
		System.out.println("Done");
	}
}