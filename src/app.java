import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class app {

	private static HashMap<Character, Integer> letterTable;
	private static HashMap<Character, Double> percentageTable;
	private static String SPACING = "\t\t";

	public static void main(String args[]) {
		String[] fileArray = null;

		if(args.length <= 0)
			fileArray = new String[] {"T1"};
		else if (args[0].equals("all"))
			fileArray = new String[] {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "TextoClaro"};
		else
			fileArray = args[0].split("\\s");

		// Read file
		for(String file : fileArray){
			letterTable = buildLetterTable();
			percentageTable = buildPercentageTable();
			read(file);

			System.out.println("Running for file: " + file);
			FileManager.record(file, embedPercentage(letterTable, percentageTable));
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
		char[] array = data.toCharArray();
		int size = data.length();

		for (char letter : array)
			letterTable.put(letter, letterTable.get(letter) + 1);

		letterTable.forEach((k, v) -> {
			percentageTable.put((char) k, (double) (v * 100) / size);
        });
	}





	private static String[] formatMapString(HashMap map) {
		return map.toString()
					.replaceAll("\\{","")
					.replaceAll("\\}","")
					.split(", ");
	}

	private static String embedPercentage(HashMap letters, HashMap percentage) {
		String[] format = formatMapString(letters);
		String result = "";
		for(String letter : format)
			result += letter + SPACING + String.format("%,.2f",percentage.get(letter.charAt(0))) + " %\n";

		return result.replaceAll("=", SPACING);
	}





	private static HashMap<Character, Integer> buildLetterTable() {
		HashMap<Character, Integer> table = new HashMap<Character, Integer>();
		for(int i = 0; i < 26; i++){
			table.put((char) (97 + i), 0);
		}

		return table;
	}

	private static HashMap<Character, Double> buildPercentageTable() {
		HashMap<Character, Double> table = new HashMap<Character, Double>();
		for(int i = 0; i < 26; i++){
			table.put((char) (97 + i), 0.0);
		}

		return table;
	}

}