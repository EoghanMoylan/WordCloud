package ie.gmit.sw;

public class Runner
{
	public static void main(String[] args) throws Exception 
	{
		ImageGenerator img;
		
		StopwordsList stopWords = new StopwordsList("stopwordswithtags.txt");
		System.out.println("Stopwords parsed...");
		UrlParser toParse = new UrlParser(stopWords);
		toParse.parse("http://www.gmit.ie/");
		//MainMap map = new MainMap("Tolstoy.txt", stopWords, 200,true);
		
		img = new ImageGenerator(toParse.getMap(), 200);
		System.out.println("Drawing Image...");
		img.drawImage();
		
		System.out.println("Done");
	}
}