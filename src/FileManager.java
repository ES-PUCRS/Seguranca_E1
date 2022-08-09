import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import java.util.Scanner;

public class FileManager {
	
	private static final String content = "\\src\\content\\";
	private static final String extension = ".txt";
	public FileManager() {}

	public static Scanner readable(final String fileName) throws FileNotFoundException, IOException {
		String path = new File(".").getCanonicalPath() + content + fileName + extension;
		return new Scanner(new File(path));
	}

}