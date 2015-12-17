package Div325;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class D {
	static LinkedList<Point>[] trains = new LinkedList[3]; // [0][i]
	static int n, k, level = 0;
	static int dp[][] = new int[3][101];

	static boolean can(int curr, int level) {
		if (level > 2 || level < 0)
			return false;
		if (curr >= n)
			return true;
		if (dp[level][curr] != -1)
			return false;
		int c = curr + 1;
		for (Point p : trains[level]) {
			if (curr >= p.x - curr * 2 && curr <= p.y - curr * 2)
				return false;
			if (c < n && c >= p.x - curr * 2 && c <= p.y - curr * 2)
				return false;
		}
		if (level != 0) {
			boolean ans = true;
			for (Point p : trains[level - 1]) {
				if (c < n && c >= p.x - curr * 2 && c <= p.y - curr * 2) {
					ans = false;
					break;
				}
			}
			if (ans) {
				ans &= can(c, level - 1);
				if (ans)
					return true;
			}
		}
		if (level != 2) {
			boolean ans = true;
			for (Point p : trains[level + 1]) {
				if (c < n && c >= p.x - curr * 2 && c <= p.y - curr * 2) {
					ans = false;
					break;
				}
			}
			if (ans) {
				ans &= can(c, level + 1);
				if (ans)
					return true;
			}
		}
		if (can(c, level)) {
			return true;
		} else {
			dp[level][curr] = 1;
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		while (t-- > 0) {
			for (int i = 0; i < trains.length; i++) {
				trains[i] = new LinkedList<>();
			}
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			k = Integer.parseInt(l[1]);
			getLine(bf.readLine().toCharArray(), 0);
			getLine(bf.readLine().toCharArray(), 1);
			getLine(bf.readLine().toCharArray(), 2);
			System.out.println(can(0, level) ? "YES" : "NO");
		}
	}

	private static void getLine(char[] line, int index) {
		Arrays.fill(dp[index], -1);
		int start = -1;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == 's') {
				level = index;
				continue;
			}
			if (line[i] == '.') {
				if (start != -1) {
					trains[index].add(new Point(start, i - 1));
					start = -1;
				}
			} else {
				if (start == -1) {
					start = i;
				} else {
					if (line[start] != line[i]) {
						trains[index].add(new Point(start, i - 1));
						start = i;
					}
				}
			}
		}
		if (start != -1) {
			trains[index].add(new Point(start, n - 1));
		}
	}
}
