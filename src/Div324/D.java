package Div324;

import java.util.Scanner;

public class D {
	static int N = 30000;
	static int primes[] = new int[N];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		genPrimes();
		if (isPrime(n)) {
			System.out.println(1+"\n"+n);
			return;
		}
		int temp;
		for (int i = 0; i < N && primes[i] < n; i++) {
			temp = n - primes[i];
			if (isPrime(temp)) {
				System.out.println(2);
				System.out.println(temp + " " + primes[i]);
				return;
			}
			for (int j = 0; j < N && primes[i] < n; j++) {
				if (isPrime(temp - primes[j])) {
					System.out.println(3);
					System.out.println(temp - primes[j] + " " + primes[i] + " "
							+ primes[j]);
					return;
				}
			}
		}
		System.out.println(-1);
	}

	static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void genPrimes() {
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i < N; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., N/i
			if (isPrime[i]) {
				for (int j = i; i * j < N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		int p = 0;
		for (int i = 2; i < N; i++) {
			if (isPrime[i]) {
				primes[p++] = i;
			}
		}
	}
}
