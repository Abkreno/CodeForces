import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		input.init(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int k = input.nextInt();
		int[] nums = new int[m];
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
			max = Math.max(max, nums[i]);
		}
		int ff = input.nextInt();
		char fedor[] = Integer.toBinaryString(ff).toCharArray();
		max = Math.max(max, ff);
		int len = Integer.toBinaryString(max).length();
		char fedora[] = new char[len];
		Arrays.fill(fedora, '0');
		int ii = len - 1;
		for (int i = fedor.length - 1; i >= 0; i--) {
			fedora[ii--] = fedor[i];
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			char curr[] = Integer.toBinaryString(nums[i]).toCharArray();
			char curra[] = new char[len];
			int d = 0;
			Arrays.fill(curra, '0');
			ii = len - 1;
			for (int j = curr.length - 1; j >= 0; j--) {
				curra[ii--] = curr[j];
			}
			int cc = 0;
			for (int j = len - 1; j >= 0; j--) {
				if (curra[j] != fedora[j])
					d++;
				cc++;
				if (cc == n)
					break;
			}
			if (d <= k)
				res++;
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
