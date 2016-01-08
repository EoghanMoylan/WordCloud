package ie.gmit.sw;
import java.util.*;

public interface Parsable
{
	public void parse(String filename) throws Exception;
	public Map<String, Integer> getMap();
}
