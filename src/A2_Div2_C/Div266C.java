package A2_Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div266C {
	static long vals[];
	static long sums[];
	static int[][] DP;

	static int f(int curr, int lastTaken, int splitC, long sum, boolean ok) {
		if (splitC == 3 && curr >= vals.length && ok)
			return 1;
		if (splitC > 3)
			return 0;
		if (curr >= vals.length)
			return 0;
		if (DP[curr][splitC] != -1)
			return DP[curr][splitC];
		long s = sums[curr] - sums[lastTaken];

		if (sum == s) {
			return f(curr + 1, curr, splitC + 1, sum, true)
					+ f(curr + 1, lastTaken, splitC, sum, false);
		} else {
			return f(curr + 1, lastTaken, splitC, sum, false);
		}

	}

	public static void main(String[] args) throws IOException {
		input.init(System.in);
		int n = input.nextInt();
		vals = new long[n];
		sums = new long[n];
		DP = new int[n + 1][4];
		for (int i = 0; i < DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}
		for (int i = 0; i < vals.length; i++) {
			vals[i] = input.nextLong();
			if (i == 0)
				sums[i] = vals[i];
			else
				sums[i] = vals[i] + sums[i - 1];
		}
		int res = 0;
		for (int i = 0; i < vals.length; i++) {
			int c = f(i + 1, i, 1, sums[i], false);
			res += c;
		}
		System.out.println(res);
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
