package ie.gmit.sw;

public class Runner
{
	public static void main(String[] args) throws Exception 
	{
		StopwordsList stopWords = new StopwordsList("stopwords.txt");
		Parsable toParse = new MainMap("Tolstoy.txt", stopWords, 7);	
		System.out.println("Done");
	}
}