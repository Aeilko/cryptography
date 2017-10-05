package ass59;

public class Solver {
	
	private static Integer N = 713;
	private static Integer p = 23;
	private static Integer q = 31;
	private static Integer m1 = 6;
	private static Integer m2 = 42;
	
	private static void solve() {
		// 1 < e < 0(N), e relatively prime to 0(N) = 0(p)0(q) = (p-1)(q-1).
		// gcd(e, (p - 1)(q - 1)) = 1
		boolean found = false;
		int solutionA = 2;
		while(!found) {
			if(gcd((p-1)*(q-1), solutionA) == 1 )
				found = true;
			else
				solutionA++;
		}
		System.out.println("a:\t\t" + solutionA);
		
		found = false;
		int solutionB = 0;
		for(int s = 1; s < solutionA &! found; s++) {
			if( (float) (((s * (p-1)*(q-1) + 1)/7.0) % 1.0) == 0.0) {
				found = true;
				solutionB = (int) ((s * (p-1)*(q-1) + 1)/7.0);
			}
		}
		System.out.println("b:\t\t" + solutionB);
		
		int solutionC = (int) (Math.pow(6, 7) % N);
		System.out.println("c:\t\t" + solutionC);
		
		
		System.out.println("d:\t\t");
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
