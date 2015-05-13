import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Flower_DP {
	static long DP[];
	static int MOD = 1000000007;

	static long K_one(int n) {
		BigInteger b = new BigInteger("2");
		b = b.pow(n);
		b = b.mod(new BigInteger(MOD + ""));
		return b.longValue();
	}

	static long TwoPowN(int n) {
		return DP[n] = (2 * DP[n - 1]) % MOD;
	}

	public static void main(String[] args) {
		DP = new long[100001];
		DP[1] = 2;
		for (int i = 2; i <= 100000; i++) {
			TwoPowN(i);
		}
		long ans = 0;
		for (int i = 1; i <= 100000; i++) {
			ans += DP[i];
			ans %= MOD;
		}
		System.out.println(ans);
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
