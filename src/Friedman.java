import java.util.HashMap;

public class Friedman {

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

}