import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RegSystem {
	public static void main(String[] args) throws Exception {
		input.init(System.in);
		int n = input.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String s = input.next();
			if (map.containsKey(s)) {
				int c = map.get(s);
				c++;
				map.put(s, c);
				System.out.println(s + c);
			} else {
				System.out.println("OK");
				map.put(s, 0);
			}
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
