import java.lang.Math;

public class Vigenere {

	public static String decode(String cipher, String key) {
		System.out.println("Decoding...");
		char[] array = cipher.toUpperCase().toCharArray();
		int size = cipher.length();
		String plainText = "";

		int previous = 0;
		int percentage = 0;
		int turn = 0;
		int nl = 0;
		int i = 0;
		for (char letter : array) {
			percentage = (((i*100) / array.length));
			if (percentage % 5 == 0 && percentage != previous) {
				previous = percentage;
				System.out.print(".." + percentage + "%");
			}

			if(letter == 32) {
				plainText+= " ";
				continue;
			}
			
			if(turn >= key.length()) turn = 0;

			nl = ((int)letter-65) - ((int)key.charAt(turn)-65);
			if (nl < 0) nl = 26 - Math.abs(nl);
			plainText += app.alphabet[nl];
			
			turn++;
			i++;
			// MAKE IT FASTER
			if(i > 5000) break;
		}
		
		return plainText;
	}

}
// ASC(caracter)-ASC(a) - isto me dará um valor de 0..25.