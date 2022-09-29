import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class app {

	public static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	

	private static HashMap<Character, Integer> letterTable;
	private static HashMap<Character, Double> percentageTable;
	private static String cipher = "";
	private static String SPACING = "\t\t";

	public static void main(String args[]) {
		String[] fileArray = null;

		if(args.length <= 0)
			 fileArray = new String[] {"ciphers"};
		else fileArray = args[0].split(",");

		// Read file
		for(String file : fileArray) {
			letterTable = buildLetterTable();
			percentageTable = buildPercentageTable();
			read(file);
			

			double friedmanTest = Friedman.test(letterTable);
			double friedmanTest = Friedman.decrypt(cipher);
			System.out.println("Running for file: " + file);
			FileManager.record(
				file,
				embedPercentage(letterTable, percentageTable, friedmanTest) + "\n\n"
				// + Vigenere.decode(cipher, "AVELINO")
			);
		}
	}


	private static void read(String file) {
		try {
			Scanner scanner = FileManager.readable(file);
			while(scanner.hasNextLine()) {
				handler(scanner.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void handler(String data) {
		if(data.length() <= 0) return;
		char[] array = data.toUpperCase().toCharArray();
		int size = data.length();
		cipher += data;

		for (char letter : array)
			if(letter != 32)
				letterTable.put(letter, letterTable.get(letter) + 1);

		letterTable.forEach((k, v) -> {
			percentageTable.put((char) k, (double) (v * 100) / size);
        });
	}



	private static String embedPercentage(HashMap letters, HashMap percentage, double friedmanTest) {
		String[] format = formatMapString(letters);
		String result = "";
		for(String letter : format)
			result += letter + SPACING + String.format("%,.2f",percentage.get(letter.charAt(0))) + " %\n";

		return result.replaceAll("=", SPACING) + String.format("%,.6f",friedmanTest);
	}








	private static String[] formatMapString(HashMap map) {
		return map.toString()
					.replaceAll("\\{","")
					.replaceAll("\\}","")
					.split(", ");
	}

	private static HashMap<Character, Integer> buildLetterTable() {
		HashMap<Character, Integer> table = new HashMap<Character, Integer>();
		for(int i = 0; i < 26; i++){
			table.put((char) (65 + i), 0);
		}

		return table;
	}

	private static HashMap<Character, Double> buildPercentageTable() {
		HashMap<Character, Double> table = new HashMap<Character, Double>();
		for(int i = 0; i < 26; i++){
			table.put((char) (65 + i), 0.0);
		}

		return table;
	}

}