package general;

public class Functions {
	/**
	 * Converts the given string of bits to a boolean array
	 * @param in The string of bits
	 * @return boolean[] representation of the bit string.
	 */
	public static boolean[] StringToArray(String in) {
		boolean[] result = new boolean[in.length()];
		
		char[] bits = in.toCharArray();
		int i = 0;
		for(char a: bits) {
			result[i] = (a == '1');
			i++;
		}
		
		return result;
	}
	
	/**
	 * Converts the given boolean[] to a bit string
	 * @param in The boolean array to be converted
	 * @return The string representation of the boolean[]
	 */
	public static String ArrayToString(boolean[] in) {
		String result = "";
		
		for(boolean a: in) {
			result += (a ? "1" : "0");
		}
		
		return result;
	}
	
	/**
	 * Returns the binary string representation with leading 0's of the given integer
	 * @param in int Value to be converterd to a binary string
	 * @param length The length the binary code has to be
	 * @require length <= 32
	 * @return
	 */
	public static String intToBinaryString(int in, int length) {
		String bin = Integer.toBinaryString(in);
		return ("00000000000000000000000000000000" + bin).substring(32-length+bin.length());
	}
	/**
	 * Performs intToBinaryString with length of 5
	 */
	public static String intToBinaryString(int in) {
		return intToBinaryString(in, 5);
	}
	
	/**
	 * Return the int value of the given binary string
	 * @param in The binary String
	 * @return int value of the Binary string given
	 */
	public static int binaryStringToInt(String in) {
		return Integer.parseInt(in, 2);
	}
}
