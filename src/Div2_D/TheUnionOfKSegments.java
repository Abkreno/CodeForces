package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TheUnionOfKSegments {
	static class P implements Comparable<P> {
		int x;
		boolean start;

		P(int x, boolean s) {
			start = s;
			this.x = x;
		}

		@Override
		public int compareTo(P o) {
			if (x == o.x) {
				if (start == o.start)
					return 0;
				if (start)
					return -1;
				else
					return 1;
			}
			return Integer.compare(x, o.x);
		}

		public String toString() {
			return (start ? "s" : "e") + " " + x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		P[] points = new P[n * 2];
		int a, b, c = 0;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			points[c++] = new P(a, true);
			points[c++] = new P(b, false);
		}
		Arrays.sort(points);
		int s = k == 1 ? 0 : -1;
		int count = 0;
		int segmants = 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < points.length; i++) {
			if (points[i].start)
				segmants++;
			else {
				segmants--;
			}
			if (segmants >= k) {
				if (s == -1) {
					s = i;
				}
			} else {
				if (s != -1) {
					count++;
					sb.append(points[s].x + " " + points[i].x + "\n");
					s = -1;
				}
			}
		}
		if (s != -1) {
			count++;
			sb.append(points[s].x + " " + points[points.length - 1].x + "\n");
		}
		System.out.println(count);
		System.out.print(sb);
	}
}
