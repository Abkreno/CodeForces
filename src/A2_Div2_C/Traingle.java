package A2_Div2_C;

import java.util.Scanner;

public class Traingle {
	static double eps = 1e-6;

	static boolean equal(double a, double b) {
		return Math.abs(a - b) < eps;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean found = false;
		loop: for (int x = 1; x <= a; x++) {
			int y = getSides(a, x, 0);
			if (y == 0)
				continue;
			for (int x2 = 1; x2 <= b; x2++) {
				int y2 = getSides(b, x2, y);
				if (y2 == 0)
					continue;
				if (check(new int[] { x, y }, new int[] { -x2, y2 }, a * a + b
						* b)) {
					found = true;
					System.out.println("YES\n0 0\n" + x + " " + y + "\n"
							+ (-x2) + " " + y2);
					break loop;
				}
			}
		}
		if (!found)
			System.out.println("NO");
	}

	static boolean check(int[] co1, int[] co2, int l) {
		int x = (co1[0] - co2[0]);
		x *= x;
		int y = (co1[1] - co2[1]);
		y *= y;
		return x + y == l;
	}

	static int getSides(int a, int x, int d) {
		int y = 0;
		int yy = (a * a - x * x);
		y = (int) Math.sqrt(yy);
		if (y == 0 || y == d)
			return 0;
		if (equal(Math.sqrt(yy), (double) y)) {
			return y;
		}
		return 0;
	}
}
