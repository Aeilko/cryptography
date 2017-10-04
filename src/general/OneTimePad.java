package general;

public class OneTimePad {
	
	private boolean[] key;
	private int keyLength;
	
	// Constructor
	public OneTimePad(boolean[] key) {
		this.key = key;
		this.keyLength = key.length;
	}
	
	public OneTimePad(String key) {
		this.key = StringToArray(key);
		this.keyLength = key.length();
	}
	
	public boolean[] encode(boolean[] input) {
		boolean[] result = new boolean[input.length];
		
		int i = 0;
		for(boolean a: input) {
			result[i] = ((a || key[i%this.keyLength]) && !(a && key[i%this.keyLength]));
			i++;
		}
		
		return result;
	}
	
	public String encode(String input) {
		return ArrayToString(encode(StringToArray(input)));
	}
	
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
}
