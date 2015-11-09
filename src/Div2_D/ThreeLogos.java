package Div2_D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ThreeLogos {
	static char[][] res;
	static int maxW, maxH;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c1[] = new int[2];
		c1[0] = sc.nextInt();
		c1[1] = sc.nextInt();
		int c2[] = new int[2];
		c2[0] = sc.nextInt();
		c2[1] = sc.nextInt();
		int c3[] = new int[2];
		c3[0] = sc.nextInt();
		c3[1] = sc.nextInt();
		P[] p = new P[3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					p[0] = new P(c1[i], c1[1 - i], 'A');
					p[1] = new P(c2[j], c2[1 - j], 'B');
					p[2] = new P(c3[k], c3[1 - k], 'C');
					if (possible(p)) {
						print();
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				sb.append(res[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(maxH + "\n" + sb);
	}

	static class P {
		int x, y;
		char c;

		P(int i, int j, char k) {
			x = i;
			y = j;
			c = k;
		}

		public String toString() {
			return x + " " + y;
		}
	}

	static boolean possible(P[] p) {
		// x = width y = height
		Arrays.sort(p, new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return -Integer.compare(o1.x, o2.x);
			}
		});
		if (p[0].x == p[1].x && p[1].x == p[2].x) {
			maxW = p[0].x;
			maxH = p[0].y + p[1].y + p[2].y;
			if (maxW == maxH) {
				res = new char[maxH][maxW];
				int stY = 0;
				int endY = p[0].y;
				fill(stY, endY, 0, maxW, p[0].c);
				stY += p[0].y;
				endY = stY + p[1].y;
				fill(stY, endY, 0, maxW, p[1].c);
				stY += p[1].y;
				endY = stY + p[2].y;
				fill(stY, endY, 0, maxW, p[2].c);
				return true;
			}
		}
		if (p[0].x == p[1].x + p[2].x && p[1].y == p[2].y) {
			maxW = p[0].x;
			maxH = p[0].y + p[1].y;
			if (maxW == maxH) {
				res = new char[maxH][maxW];
				fill(0, p[0].y, 0, maxW, p[0].c);
				fill(p[0].y, p[0].y + p[1].y, 0, p[1].x, p[1].c);
				fill(p[0].y, p[0].y + p[1].y, p[1].x, p[1].x + p[2].x, p[2].c);
				return true;
			}
		}
		return false;

	}

	private static void fill(int sy, int y, int sx, int x, char c) {
		for (int i = sy; i < y; i++) {
			for (int j = sx; j < x; j++) {
				res[i][j] = c;
			}
		}
	}
}
