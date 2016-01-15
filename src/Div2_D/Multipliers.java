package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multipliers {
	static long mod = 1000000000 + 7;
	static int max = 200000;
	static long counts[] = new long[max + 5];
	static long multRight[] = new long[max + 5];
	static long multLeft[] = new long[max + 5];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int curr;
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			counts[curr]++;
		}
		multLeft[0] = 1;
		for (int i = 1; i <= max; i++) {
			multLeft[i] = (counts[i] + 1);
			multLeft[i] *= multLeft[i - 1];
			multLeft[i] %= (mod - 1);
		}
		multRight[max + 1] = 1;
		for (int i = max; i >= 0; i--) {
			multRight[i] = (counts[i] + 1);
			multRight[i] *= multRight[i + 1];
			multRight[i] %= (mod - 1);
		}
		long powers, t, ans = 1;
		for (int i = 1; i <= max; i++) {
			if (counts[i] == 0)
				continue;
			powers = multLeft[i - 1] * multRight[i + 1];
			powers %= (mod - 1);
			powers *= (sum(counts[i]) % (mod - 1));
			powers %= (mod - 1);
			powers = binaryPow(i, powers);
			ans *= powers;
			ans %= mod;
		}
		System.out.println(ans);
	}

	private static long sum(long i) {
		return i * (i + 1) / 2;
	}

	static long binaryPow(long a, long q) {
		a %= mod;
		if (q == 0)
			return 1;
		return ((q % 2 == 1 ? a : 1) * binaryPow(a * a, q / 2)) % mod;
	}
}
