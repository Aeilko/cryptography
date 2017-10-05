package general;

public class OneTimePad {
	
	private final boolean[] key;
	private final int keyLength;
	
	// Constructor
	public OneTimePad(boolean[] key) {
		this.key = key;
		this.keyLength = key.length;
	}
	
	public OneTimePad(String key) {
		this.key = Functions.StringToArray(key);
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
		return Functions.ArrayToString(encode(Functions.StringToArray(input)));
	}
}
