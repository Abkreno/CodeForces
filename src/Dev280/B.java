package Dev280;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
	static int[] a;
	static int len;
	static final double EPS = 1e-9;

	static boolean check(double d) {
		if (d < a[0] || d < len - a[a.length - 1])
			return false;
		for (int i = 0; i < a.length - 1; i++) {
			double a1 = a[i];
			double a2 = a[i + 1];
			double dist = (a2 - a1) / 2.0;
			if (d < dist)
				return false;

		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		len = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		a = new int[n];
		for (int i = 0; i < l.length; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(a);
		double maxDif = Math.max(a[0], len - a[n - 1]);
		for (int i = 0; i < l.length - 1; i++) {
			double dist = ((double) a[i + 1] - a[i]) / 2.0;
			maxDif = Math.max(maxDif, dist);
		}
		if (maxDif == a[0] || maxDif == len - a[n - 1])
			System.out.println(String.format("%.10f", maxDif));
		else {
			double low = 0.0;
			double hi = (double) maxDif;
			double mid = 0.0;
			int c = 0;
			while (hi - low >= EPS && c <= 400) {
				mid = (low + hi) / 2.0;
				if (mid >= maxDif) {
					hi = mid;
				} else
					low = mid;
				c++;
			}
			System.out.println(String.format("%.10f", hi));

		}
	}
}
