package ie.gmit.sw;

public class Runner
{
	public static void main(String[] args) throws Exception 
	{
		StopwordsList stopWords = new StopwordsList("stopwords.txt");
		System.out.println("Stopwords parsed...");
		Parsable toParse = new MainMap("Tolstoy.txt", stopWords, 200);	
		System.out.println("Done");
	}
}