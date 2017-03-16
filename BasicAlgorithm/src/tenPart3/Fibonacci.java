package tenPart3;

public class Fibonacci {
	static long bottom_up(int k) {
        int N = k;
        if (N < 1 || N > 92) {
            throw new RuntimeException("N must be between 1 and 92");
        }
		long[] fib = new long[N+1];

        // base cases
        fib[0] = 0;
        fib[1] = 1;

        // bottom-up dynamic programming
        for (int n = 2; n <= N; n++)
            fib[n] = fib[n-1] + fib[n-2];

        // print results
       return fib[N];

	}
	static long top_down(int x) {
		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			return top_down(x - 1) + top_down(x - 2);
		}

		
	}
    public static void main(String[] args) {
    	System.out.println(bottom_up(10));
    	System.out.println(top_down(10));

        
    }
}
