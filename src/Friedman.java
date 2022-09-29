import java.util.HashMap;

public class Friedman {

	private static final int MIN_SUBSTRINGS = 1;
	private static final int MAX_SUBSTRINGS = 10;
	private static final ExecutorService pool = Executors.newCachedThreadPool();

	public static void decrypt(String cipher) {
		for (int i = MIN_SUBSTRINGS; i < MAX_SUBSTRINGS; i++) {

		}
	}

	private static HashMap<Character, Integer> cipherSubstringGroups(String cipher, int length) {
		if(cipher.length() <= 0) return;
		HashMap<Character, Integer> table = characterHashMapConstructor(new HashMap<Character, Integer>());
		char[] array = cipher.toUpperCase().toCharArray();
		int size = cipher.length();

		pool.execute(threadfySubstrings);
	
		for (char letter : array)
			if(letter != 32)
				table.put(letter, table.get(letter) + 1);

		return table;
	}


    private static Runnable threadfySubstrings = new Runnable() {
        public void run() {
            try{
            	if()
            		pool.execute(threadfySubstrings);
            } catch (Exception e){}
        }
    };

	public static double test(HashMap<Character, Integer> map) {
		int ni = 0;
		int nii = 0;

		for(char letter : app.alphabet) {
			int letterAppears = map.get(letter);
			
			ni += letterAppears;
			nii += letterAppears * (letterAppears - 1);
		}


		double frequency = (double) nii / (ni *(ni - 1));
		
		if(false) { // DEBUG
			System.out.println(nii);
			System.out.println("/ " + ni + " * (" + (ni-1) + ")");
			System.out.println(frequency);
		}

		return keyLength(ni, frequency);
	}

	private static double keyLength(int ni, double frequency) {
		double divident = 0.027 * ni;
		double divisor = (ni-1) * frequency - (0.038 * ni) + 0.065;

		return divident/divisor;
	}

	private static HashMap<Character, Integer> characterHashMapConstructor(HashMap<Character, Integer> table) {
		for(int i = 0; i < 26; i++) {
			table.put((char) (65 + i), 0);
		}
		return table;
	}


	private static void threadfy() {

	}
}