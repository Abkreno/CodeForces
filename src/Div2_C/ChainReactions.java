package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChainReactions {
	static class Num implements Comparable<Num> {
		int dist, p;

		Num(int i, int j) {
			dist = i;
			p = j;
		}

		@Override
		public int compareTo(Num o) {
			return Integer.compare(dist, o.dist);
		}

	}

	static int n;
	static Num nums[];

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		if (n == 1) {
			System.out.println(0);
			return;
		}
		String[] l;
		nums = new Num[n];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			nums[i] = new Num(Integer.parseInt(l[0]), Integer.parseInt(l[1]));
		}

		Arrays.sort(nums);
		int dest[] = new int[n];
		int lo, hi, mid;
		int ans = n;
		for (int i = 1; i < dest.length; i++) {
			lo = -1;
			hi = i;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (nums[mid].dist >= nums[i].dist - nums[i].p) {
					hi = mid;
				} else {
					lo = mid;
				}
			}
			// hi contains index of last affected
			if (hi == i) {
				dest[i] = dest[i - 1];
				continue;
			}
			dest[i] = i - hi;
			if (hi > 0)
				dest[i] += dest[hi - 1];

			int fall = n - i + dest[i - 1];
			ans = Math.min(ans, fall);
		}
		ans = Math.min(ans, dest[n - 1]);
		System.out.println(ans);
	}
}