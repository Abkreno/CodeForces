import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Div339A {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), A = sc.nextInt(), cf = sc.nextInt(), cm = sc
				.nextInt();
		long m = sc.nextLong();

		Skill[] a = new Skill[n];
		for (int i = 0; i < n; ++i)
			a[i] = new Skill(sc.nextInt(), i);
		shuffle(a);
		Arrays.sort(a);
		long[] prePerf = new long[n + 1];
		prePerf[n - 1] = A - a[n - 1].val;
		for (int i = n - 2; i >= 0; --i)
			prePerf[i] = prePerf[i + 1] + A - a[i].val;

		long[] preRaise = new long[n];
		for (int i = 1; i < n; ++i)
			preRaise[i] = (long) (a[i].val - a[i - 1].val) * i
					+ preRaise[i - 1];

		int bestPerf = -1, bestRaise = -1;
		long bestRVal = -1;
		long maxVal = 0;
		for (int i = 0; i <= n; ++i)
			if (m >= prePerf[i]) {
				long curVal = (long) (n - i) * cf;
				long curRVal = 0;
				long k = m - prePerf[i];
				int ans = -1, lo = 0, hi = i - 1;
				while (lo <= hi) {
					int mid = lo + (hi - lo) / 2;
					if (preRaise[mid] <= k) {
						ans = mid;
						lo = mid + 1;
					} else
						hi = mid - 1;
				}
				if (ans != -1) {
					long cur = a[ans].val
							+ (curRVal = Math.min((k - preRaise[ans])
									/ (ans + 1), A - a[ans].val));
					curVal += cur * cm;
				} else
					curVal += (long) A * cm;
				if (maxVal <= curVal) {
					bestRVal = curRVal;
					maxVal = curVal;
					bestPerf = i;
					bestRaise = ans;
				}
			}

		out.println(maxVal);
		for (int i = 0; i < n; ++i) {
			if (i <= bestRaise)
				a[i].val = a[bestRaise].val + (int) bestRVal;
			if (i >= bestPerf)
				a[i].val = A;

		}
		Arrays.sort(a, new Indexer());
		for (int i = 0; i < n - 1; ++i)
			out.format("%d ", a[i].val);
		out.format("%d\n", a[n - 1].val);
		out.flush();
		out.close();

	}

	static void shuffle(Skill[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			Skill tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

	static class Skill implements Comparable<Skill> {
		int val, idx;

		Skill(int x, int y) {
			val = x;
			idx = y;
		}

		public int compareTo(Skill s) {
			if (val != s.val)
				return val - s.val;
			return idx - s.idx;
		}
	}

	static class Indexer implements Comparator<Skill> {
		public int compare(Skill s1, Skill s2) {
			return s1.idx - s2.idx;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}