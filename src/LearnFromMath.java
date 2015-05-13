import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LearnFromMath {
	static class myStr implements Comparable<myStr> {
		String st;
		int index;

		myStr(String s, int index) {
			this.st = s;
			this.index = index;
		}

		@Override
		public int compareTo(myStr o) {
			return st.compareTo(o.st);
		}

		public String toString() {
			return this.st + " " + this.index;
		}
	}

	static myStr[] arr;
	static int[] p;
	static int[] indexes;
	static byte checked[];

	static boolean check(int curr, int currentP) {
		if (currentP == p.length)
			return true;
		if (curr == arr.length)
			return false;
		myStr arra[] = arr;
		myStr tmp = arr[curr];
		if (arr[curr].index == p[currentP]) {
			checked[p[currentP]]++;
			boolean f = check(curr + 1, currentP + 1);
			if (f)
				return true;

			f = (checked[currentP] >= 2) ? false : check(curr + 1, currentP);
			if (f)
				return true;
			checked[p[currentP]]--;
		} else {
			checked[arr[curr].index]++;
			if (checked[arr[curr].index] >= 2
					&& indexes[arr[curr].index] > currentP) {
				checked[arr[curr].index]--;
				return false;
			}
			boolean f = check(curr + 1, currentP);
			if (f)
				return true;
			checked[arr[curr].index]--;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		input.init(System.in);
		int n = input.nextInt();
		arr = new myStr[2 * n];
		int ind = 1;
		for (int i = 0; i < arr.length; i += 2) {
			arr[i] = new myStr(input.next(), ind);
			arr[i + 1] = new myStr(input.next(), ind++);
		}
		Arrays.sort(arr);
		p = new int[n];
		indexes = new int[n + 1];
		for (int i = 0; i < n; i++) {
			p[i] = input.nextInt();
			indexes[p[i]] = i;
		}
		checked = new byte[n * 2 + 2];
		System.out.println(check(0, 0) ? "YES" : "NO");

	}

	// fast input
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
