package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bombs {
	static class Point implements Comparable<Point> {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (y == o.y) {
				if (Math.abs(x) == Math.abs(o.x)) {
					return 0;
				}
				return Math.abs(x) - Math.abs(o.x) > 0 ? 1 : -1;
			} else {
				return Math.abs(y) - Math.abs(o.y) > 0 ? 1 : -1;
			}
		}

		public String toString() {
			return x + "/ " + y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Point[] arr = new Point[n];
		String[] l;
		int x, y;
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			x = Integer.parseInt(l[0]);
			y = Integer.parseInt(l[1]);
			arr[i] = new Point(x, y);
		}
		Arrays.sort(arr);
		int steps = 0;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < n; i++) {
			x = arr[i].x;
			y = arr[i].y;
			if (x == 0 || y == 0) {
				steps += 4;
			} else {
				steps += 6;
			}
			if (x > 0) {
				ans.append("1 " + x + " R\n");
			} else if (x < 0) {
				ans.append("1 " + (x * -1) + " L\n");
			}
			if (y > 0) {
				ans.append("1 " + y + " U\n");
			} else if (y < 0) {
				ans.append("1 " + (y * -1) + " D\n");
			}
			ans.append("2\n");
			if (y > 0) {
				ans.append("1 " + y + " D\n");
			} else if (y < 0) {
				ans.append("1 " + (y * -1) + " U\n");
			}
			if (x > 0) {
				ans.append("1 " + x + " L\n");
			} else if (x < 0) {
				ans.append("1 " + (x * -1) + " R\n");
			}
			ans.append("3\n");
		}
		System.out.print(steps + "\n" + ans);
	}
}
