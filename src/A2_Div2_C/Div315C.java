package A2_Div2_C;
import java.io.IOException;
import java.util.Scanner;

public class Div315C {
	static int N = 10000001;
	static int DP[] = new int[N];
	static int primeCounts[] = new int[N];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DP[1] = 1;
		for (int i = 2; i < N; i++) {
			DP[i] += DP[i - 1];
			if (checkPalind(i))
				DP[i]++;
		}
		long p = sc.nextInt();
		long q = sc.nextInt();
		count();
		long primes, palnd;
		for (int i = N - 1; i >= 1; i--) {
			palnd = DP[i];
			primes = primeCounts[i];
			if (q * primes <= p * palnd) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("Palindromic tree is better than splay tree");

	}

	static void count() {

		// initially assume all integers are prime
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= N; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 2; i < N; i++) {
			if (isPrime[i])
				primeCounts[i]++;
			primeCounts[i] += primeCounts[i - 1];
		}
	}

	private static boolean checkPalind(int n) {
		char[] tmp = (n + "").toCharArray();
		int l = tmp.length;
		for (int i = 0; i < l / 2; i++) {
			if (tmp[i] != tmp[l - 1 - i]) {
				return false;
			}
		}
		return true;
	}

}
