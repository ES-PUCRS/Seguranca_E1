import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import java.util.Scanner;

public class FileManager {
	
	private static final String content = "\\src\\content\\";
	private static final String result = "\\src\\result\\";
	private static final String extension = ".txt";
	public FileManager() {}

	public static Scanner readable(final String fileName) throws FileNotFoundException, IOException {
		String path = new File(".").getCanonicalPath() + content + fileName + extension;
		return new Scanner(new File(path));
	}

	public static void record(String fileName, String data) {
		try {
			String path = new File(".").getCanonicalPath() + result;
			File directory = new File(path);
		    if (!directory.exists()){
		        directory.mkdir();
		    }

			FileWriter writer = new FileWriter(path + fileName + extension);
	      	writer.write(data);
	      	writer.close();
      	} catch (IOException e) {
			e.printStackTrace();
		}
	}

}