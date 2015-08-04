package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CaseOfFugitive {
	static class Bridge implements Comparable<Bridge> {
		long minDist, maxDist;
		int ind;

		Bridge(long mn, long mx, int i) {
			minDist = mn;
			maxDist = mx;
			ind = i;
		}

		@Override
		public int compareTo(Bridge o) {
			if (minDist > o.minDist)
				return -1;
			if (minDist < o.minDist)
				return 1;
			if (maxDist > o.maxDist)
				return -1;
			if (maxDist < o.maxDist)
				return 1;
			return 0;
		}
	}

	static class B implements Comparable<B> {
		long val;
		int ind;

		B(long v, int i) {
			val = v;
			ind = i;
		}

		@Override
		public int compareTo(B o) {
			if (val > o.val)
				return 1;
			if (val < o.val)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		Bridge[] bridges = new Bridge[n - 1];
		l = bf.readLine().split(" ");
		long prevA = Long.parseLong(l[0]);
		long prevB = Long.parseLong(l[1]);
		for (int i = 0; i < n - 1; i++) {
			l = bf.readLine().split(" ");
			long a = Long.parseLong(l[0]);
			long b = Long.parseLong(l[1]);
			bridges[i] = new Bridge(a - prevB, b - prevA, i);
			prevA = a;
			prevB = b;
		}
		Arrays.sort(bridges);
		l = bf.readLine().split(" ");
		ArrayList<B> b = new ArrayList<B>(m);
		for (int i = 0; i < m; i++) {
			b.add(new B(Long.parseLong(l[i]), i));
		}
		Collections.sort(b);

		if (m < n - 1) {
			System.out.println("No");
			return;
		}
		int ans[] = new int[n - 1];
		int j = 0;
		long c;
		for (int i = 0; i < bridges.length; i++) {
			int lo = -1;
			int hi = b.size();
			while (lo + 1 < hi) {
				int mid = (lo + hi) / 2;
				c = b.get(mid).val;
				if (bridges[i].maxDist >= c) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			if (lo == -1)
				lo++;
			if ((c = b.get(lo).val) < bridges[i].minDist
					|| c > bridges[i].maxDist) {
				System.out.println("No");
				return;
			} else {
				ans[bridges[i].ind] = b.remove(lo).ind;
			}
		}
		StringBuilder sb = new StringBuilder();
		System.out.println("Yes");
		for (int i = 0; i < ans.length; i++) {
			sb.append((ans[i] + 1) + " ");
		}
		System.out.println(sb);
	}
}