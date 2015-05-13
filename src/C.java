import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	static long nums[];
	static int m, k;

	static long f(int curr, int kk) {
		if (curr < 0 || kk == k)
			return 0;
		long max = 0;

		return curr;
	}

	public static void main(String[] args) throws IOException {
		input.init(System.in);
		int n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		nums = new long[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.nextLong();
		}
		Arrays.sort(nums);
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
