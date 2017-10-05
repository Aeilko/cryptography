package ass57;

import general.Functions;

public class OFB {
	
	private int n;
	private boolean[] vector;
	private final int key;
	private int r;
	
	public OFB(int key, String IV, int r) {
		this(key, Functions.StringToArray(IV), r);
	}
	
	public OFB(int key, boolean[] IV, int r) {
		this.vector = IV;
		this.key = key;
		this.r = r;
		this.n = IV.length;
	}
	
	public boolean[] encode(boolean[] in) {
		boolean[] result = new boolean[in.length];
		
		for(int i = 0; i < in.length; i += this.r) {
			nextOrbit();
			for(int j = 0; (j < this.r && (i+j) < in.length); j++) {
				result[i+j] = ((in[i+j] || this.vector[j]) && !(in[i+j] && this.vector[j]));
			}
		}
		
		return result;
	}
	
	private void nextOrbit() {
		int vector = Functions.binaryStringToInt(Functions.ArrayToString(this.vector));
		int newVectorInt = ((vector+this.key)-1)%32;
		boolean[] newVector = Functions.StringToArray(Functions.intToBinaryString(newVectorInt, this.n));
		this.vector = newVector;
		System.out.println("Vector:\t\t\t" + Functions.ArrayToString(this.vector));
	}
}