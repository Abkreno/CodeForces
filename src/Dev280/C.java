package Dev280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	static int n;
	static long r, avg;
	static int[] a, b;
	static long INF = (long) Integer.MAX_VALUE * 100000000;
	static long DP[][];

	static long findMin(int curr, int g) {
		if (g <= 0)
			return 0;
		if (curr >= n)
			return INF;
		if (DP[curr][g - 1] != -1)
			return DP[curr][g - 1];
		long min = findMin(curr + 1, g);
		int c = 1;
		for (int i = a[curr]; i < r; i++) {
			long x = ((long) c) * ((long) b[curr]);
			min = Math.min(min, x + findMin(curr + 1, g - c));
			c++;
			if (c > g)
				break;
		}
		return DP[curr][g - 1] = min;
	}

	public static void main(String[] args) throws Exception {
		input.init(System.in);
		n = input.nextInt();
		r = input.nextLong();
		avg = input.nextLong();
		avg = Math.min(avg, 1000000);
		long sum = 0;
		a = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
			sum += a[i];
			b[i] = input.nextInt();
		}
		BigInteger b = new BigInteger(avg + "");
		b = b.multiply(new BigInteger(n + ""));
		b = b.subtract(new BigInteger(sum + ""));

		int g = (int) b.longValue();
		if (g <= 0) {
			System.out.println(0);
		} else {
			DP = new long[n][g];
			for (int i = 0; i < DP.length; i++) {
				Arrays.fill(DP[i], -1);
			}
			System.out.println(findMin(0, g));
		}
	}

	public static class input {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		/** call this method to initialize reader for InputStream */
		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		/** get next word */
		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				// TODO add check for eof if necessary
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
