package ass59;

public class Solver {
	
	private static Integer N = 713;
	private static Integer p = 23;
	private static Integer q = 31;
	private static Integer m = 6; // message 5.9c
	private static Integer s = 17; // signature 5.9d
	
	private static void solve() {
		// 1 < e < 0(N), e relatively prime to 0(N) = 0(p)0(q) = (p-1)(q-1).
		// gcd(e, (p - 1)(q - 1)) = 1
		boolean found = false;
		int solutionA = 2; // relatively prime to (p-1)*(q-1), so at least 2
		while(!found) {
			if(gcd((p-1)*(q-1), solutionA) == 1 ) // find solution recursively
				found = true;
			else
				solutionA++;
		}
		System.out.println("a:\t\t" + solutionA); // solution to 5.9a
		
		found = false;
		int solutionB = 0;
		for(int s = 1; s < solutionA &! found; s++) {
			if( (float) (((s * (p-1)*(q-1) + 1)/7.0) % 1.0) == 0.0) { // c*d = 1 mod 0(N)
				found = true;
				solutionB = (int) ((s * (p-1)*(q-1) + 1)/7.0);
			}
		}
		System.out.println("b:\t\t" + solutionB); // solution to 5.9b
		
		int solutionC = (int) (Math.pow(m, 7) % N); // encrypt message with m^c mod N
		System.out.println("c:\t\t" + solutionC); // solution to 5.9c
		
		int solutionD = (int) (Math.pow(s, 7) % N); // "encrypt" signature with s^c mod N
		System.out.println("d:\t\t" + solutionD); // solution to 5.9d
	}
	
	public static int gcd(int pq, int mod) {
		if (mod==0) 
			return pq;
		return gcd(mod,pq%mod);
	}
	
	public static void main(String[] args) {
		Solver.solve();
	}
}
