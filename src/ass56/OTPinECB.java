package ass56;

import general.Functions;
import general.OneTimePad;

public class OTPinECB {
	
	private OneTimePad OTP;
	
	public OTPinECB(String key) {
		this.OTP = new OneTimePad(key);
	}
	
	public String encode(String i) {
		return Functions.ArrayToString(this.encode(Functions.StringToArray(i)));
	}
	
	public boolean[] encode(boolean[] in) {
		boolean[] result = new boolean[in.length];
		
		result = this.OTP.encode(in);
		
		return result;
	}
}
