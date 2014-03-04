import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Reader Class.
 * 
 * @author Marko Tandre
 *
 */
public class Reader {
	public String[] getData(String fileName) {
		String[] data = null;
		BufferedReader reader;
		try {
			String line = "";
			String dataString = "";
			reader = new BufferedReader(new FileReader(fileName));
			while((line = reader.readLine()) != null) {
				dataString += line + "\n";
			}
			reader.close();
			data = dataString.split("\n");
		} catch (Exception e) {
			System.out.println("File doesn't exist!");
		}
		return data;
	}
}
