package Dev277_5;

import java.util.Scanner;

public class C {
	static int m, S;
	static boolean foundMax, foundMin;
	static String max, min;

	static void getMax(int s, int c, String st) {
		if (c == m && s == S) {
			foundMax = true;
			max = st;
			return;
		}
		if (c == m)
			return;
		if (s <= S) {
			for (int i = 9; i >= 0; i--) {
				getMax(s + i, c + 1, st + i);
				if (foundMax)
					return;
			}
		}
		return;

	}

	static void getMin(int s, int c, String st) {
		if (c == m && s == S) {
			foundMin = true;
			min = st;
			return;
		}
		if (c == m)
			return;
		if (c == 0) {
			if (s <= S) {
				for (int i = 1; i <= 9; i++) {
					getMin(s + i, c + 1, st + i);
					if (foundMin)
						return;
				}
			}
		} else {
			if (s <= S) {
				for (int i = 0; i <= 9; i++) {
					getMin(s + i, c + 1, st + i);
					if (foundMin)
						return;
				}
			}
		}
		return;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		S = sc.nextInt();
		min = -1 + "";
		max = -1 + "";
		getMin(0, 0, "");
		getMax(0, 0, "");
		if (m > 1) {
			if (min.charAt(0) == '0')
				min = "-1";
			if (max.charAt(0) == '0')
				max = "-1";

		}
		if (m == 1 && S == 0)
			min = 0 + "";
		System.out.println(min + " " + max);
	}
}
