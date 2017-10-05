package ass57;

import general.Functions;

public class Solver {

	private static final String plainText = "honey";
	private static final int key = 11;
	private static final int shift = 3;
	private static final String IV = "01001";
	
	public static void solve() {
		System.out.println("Plaintext:\t\t" + Solver.plainText);
		
		String plaintextBin = "";
		for(int i = 0; i< plainText.length(); i++) {
			plaintextBin += Functions.intToBinaryString(charToInt(plainText.charAt(i)));
		}
		
		System.out.println("PlaintextBin:\t\t" + plaintextBin);
		
		boolean[] plaintextBits = Functions.StringToArray(plaintextBin);
		
		OFB ofb = new OFB(Solver.key, Solver.IV, Solver.shift);
		boolean[] ciphertextBits = ofb.encode(plaintextBits);
		
		String ciphertextBin = Functions.ArrayToString(ciphertextBits);
		
		System.out.println("CiphertextBin:\t\t" + ciphertextBin);
		
		String ciphertext = "";
		for(int i = 0; i < ciphertextBin.length(); i += 5) {
			String bits = ciphertextBin.substring(i, i+5);
			char a = Solver.intToChar(Functions.binaryStringToInt(bits));
			ciphertext += a;
		}
		
		System.out.println("Ciphertext:\t\t" + ciphertext);
	}
	
	/**
	 * Converts the character to it's int representation for assignment 5.6
	 * @param in
	 * @return
	 */
	public static int charToInt(char in) {
		// Convert char to a number value (a=10, z=35)
		int result = Character.getNumericValue(in);
		if(result < 0) {
			switch (in) {
				case '_':
					result = 0;
					break;
				case '.':
					result = 27;
					break;
				case ',':
					result = 28;
					break;
				case '-':
					result = 29;
					break;
				case '!':
					result = 30;
					break;
				case '?':
					result = 31;
					break;
			}
		}
		else {
			result -= 9;
		}		
		return result;
	}
	
	/**
	 * Converts the int representation to it's character for assignment 5.6
	 * @param in
	 * @return
	 */
	public static char intToChar(int in) {
		char result = '_';
		
		if(in > 0 && in < 27) {
			result = Character.forDigit(in+9, 36);
		}
		else {
			switch (in) {
				case 27:
					result = '.';
					break;
				case 28:
					result = ',';
					break;
				case 29:
					result = '-';
					break;
				case 30:
					result = '!';
					break;
				case 31:
					result = '?';
					break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Solver.solve();
	}
}
