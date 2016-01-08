package ie.gmit.sw;

public class Runner
{
	public static void main(String[] args) throws Exception 
	{

		ImageGenerator img;
		StopwordsList stopWords = new StopwordsList("stopwordswithtags.txt");
		System.out.println("Stopwords parsed...");
		MainMap map = new MainMap("http://www.gmit.ie/", stopWords,false);
		
		img = new ImageGenerator(map.getMap(), 200);
		System.out.println("Drawing Image...");
		img.drawImage();
		
		System.out.println("Done");
	}
}