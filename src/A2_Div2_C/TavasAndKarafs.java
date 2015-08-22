package A2_Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TavasAndKarafs {
	static long A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		A = Integer.parseInt(line[0]);
		B = Integer.parseInt(line[1]);
		int n = Integer.parseInt(line[2]);
		int l, t, m;
		long lo, hi, mid;
		for (int i = 0; i < n; i++) {
			line = bf.readLine().split(" ");
			l = Integer.parseInt(line[0]);
			t = Integer.parseInt(line[1]);
			m = Integer.parseInt(line[2]);
			lo = l;
			hi = 10000000;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (check(mid, t, m, l)) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			if (check(lo, t, m, l))
				System.out.println(lo);
			else
				System.out.println(-1);
		}
	}

	static boolean check(long r, int t, int m, int l) {
		long nth = A + B * (r - 1);
		if (t < nth)
			return false;
		long fn = f(r) - f(l - 1);
		long have = ((long) t) * ((long) m);
		return have >= fn;
	}

	static long f(long n) {
		if (n <= 0)
			return 0;
		return A * n + B * ((n * (n - 1)) / 2);
	}
}
