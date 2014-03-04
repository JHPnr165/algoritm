import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer Class for writing data to file.
 * 
 * @author Marko Tandre
 *
 */
public class Writer {
	String fileName;

	/**
	 * Constructor.
	 * 
	 * @param fileName Name of the file to write to.
	 */
	public Writer(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Method to write data to file given in constructor.
	 * 
	 * @param dataString Data to write to file.
	 */
	public void writeData(String dataString) {
		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			writer.write(dataString);
			writer.close();
		} catch (IOException e) {
			System.out.println("Failed to write to file!");
		}
	}
}
