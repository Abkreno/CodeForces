package Div2_D;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VanyaAndTriangles {
	static class P implements Comparable<P> {
		int x;
		boolean visitedDig1, visitedDig2, visitedHor;

		P(int x) {
			this.x = x;
		}

		@Override
		public boolean equals(Object p) {
			return ((P) p).x == x;
		}

		@Override
		public int compareTo(P o) {
			if (x > o.x)
				return 1;
			if (x < o.x)
				return -1;
			return 0;
		}
	}

	static long nCk(long n, long k) {
		if (k > n)
			return 0;
		if (k * 2 > n)
			k = n - k;
		if (k == 0)
			return 1;

		long result = n;
		for (int i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int N = 201;
		Point[] p = new Point[n];
		String[] l;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			p[i] = new Point(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					double a = Math.abs(p[i].distance(p[j]));
					double b = Math.abs(p[j].distance(p[k]));
					double c = Math.abs(p[i].distance(p[k]));
					if (lessThan(c, a + b) && lessThan(a, b + c)
							&& lessThan(b, a + c))
						ans++;

				}
			}
		}

		System.out.println(ans);
	}

	static double eps = 1e-6;

	static boolean lessThan(double a, double b) {
		return compare(a, b) == -1;
	}

	static int compare(double a, double b) {
		if (Math.abs(a - b) < eps)
			return 0;
		if (a - b < 0.0)
			return -1;
		return 1;
	}
}
