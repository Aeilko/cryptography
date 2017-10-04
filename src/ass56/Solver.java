package ass56;

public class Solver {
	
	private static String cipher = "LWPO,KJPM_V?MN,WM,YQP!QM,ZQEQLTXWMVLZQG,WVKTVLJ?LWXQ,X-GI";
	private static char padding = 'p';
	
	public static void solve() {
		System.out.println("Ciphertext:\t\t" + Solver.cipher);
		
		// Get last char, which is the padding, and XOR it with the padding to get the key
		int lastInt = charToInt(cipher.charAt(cipher.length()-1));
		int padInt = charToInt(Solver.padding);
		int keyInt = lastInt^padInt;
		String key = Solver.intToBinaryString(keyInt);
		
		System.out.println("Key:\t\t\t" + key);
		
		// Get the OTP with the key and decrypt the message
		OTPinECB otp = new OTPinECB(key);
		String plaintext = "";
		for(char a: cipher.substring(0, cipher.length()-1).toCharArray()) {
			String binary = otp.encode(Solver.intToBinaryString(Solver.charToInt(a)));
			int binaryInt = Solver.binaryStringToInt(binary);
			char res = Solver.intToChar(binaryInt);
			plaintext += res;
		}
		
		System.out.println("Plaintext:\t\t" + plaintext);
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
	
	/**
	 * Returns the binary string representation with leading 0's of the given integer
	 * @param in
	 * @return
	 */
	public static String intToBinaryString(int in) {
		return ("00000" + Integer.toBinaryString(in)).substring(Integer.toBinaryString(in).length());
	}
	
	public static int binaryStringToInt(String in) {
		return Integer.parseInt(in, 2);
	}
	
	public static void main(String[] args) {
		Solver.solve();
	}
}
