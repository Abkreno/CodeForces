import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {
	static class point implements Comparable<point> {
		int val, ind;

		point(int i, int x) {
			val = i;
			ind = x;
		}

		public String toString() {
			return val + "";
		}

		@Override
		public int compareTo(point o) {
			if (val > o.val)
				return 1;
			if (val < o.val)
				return -1;
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		point[] p = new point[n];
		for (int i = 0; i < n; i++) {
			p[i] = new point(sc.nextInt(), i);
		}
		Arrays.sort(p);
		int c = 0;
		int ans[] = new int[n];
		for (int i = 0; i < p.length; i++) {
			ans[p[i].ind] = c;
			c = 1 - c;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < p.length; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}
}
