import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div321B {
	static class N implements Comparable<N> {
		int a;
		long b;

		N(int x, int y) {
			a = x;
			b = y;
		}

		@Override
		public int compareTo(N o) {
			if (a > o.a)
				return -1;
			if (a < o.a)
				return 1;
			if (b > o.b)
				return -1;
			if (b < o.b)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		N[] nums = new N[n];
		int a, b;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			nums[i] = new N(a, b);
		}
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			nums[i].b += nums[i - 1].b;
		}
		long c, max = nums[0].b;
		int lo, hi, mid;
		for (int i = 0; i < nums.length; i++) {
			lo = i;
			hi = n;
			while (lo + 1 < hi) {
				mid = (lo + hi) >> 1;
				if (nums[i].a - nums[mid].a < m) {
					lo = mid;
				} else {
					hi = mid;
				}
			}
			c = nums[lo].b;
			if (i > 0)
				c -= nums[i - 1].b;
			max = Math.max(max, c);
		}
		System.out.println(max);
	}
}
