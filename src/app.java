import java.io.FileNotFoundException;
import java.util.Scanner;

public class app {

	public static void main(String args[]) {
		String[] fileArray = null;
		if(args.length <= 0)
			fileArray = new String[] {"T1"};
		else
			fileArray = args.split("\s");

		for(String file : fileArray)
			read(file);
	}


	private static void read(String file) {
		try {
			Scanner scanner = FileManager.readable(file);
			while(scanner.hasNextLine()) {
				handler(scanner.nextLine());
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static void handler(String data) {
		char[] array = data.toCharArray();
		for(char letter : array){
			
		}
	}
}