package general;

import java.util.HashMap;

public class FreqCounter {
	public static HashMap<Character, Integer> count(String in){
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		
		char[] letters = in.toCharArray();
		for(char a: letters) {
			result.put(a, (result.containsKey(a) ? (result.get(a) + 1) : 1));
		}
		
		return result;
	}
}
