package A2_Div2_C;

import java.util.Scanner;

public class VanyaAndScales {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int m = sc.nextInt();
		int num[] = new int[41];
		int c = 0;
		do {
			num[c++] = m % w;
		} while ((m = m / w) > 0);

		for (int i = 0; i < c; i++) {
			if (num[i] < 2)
				continue;
			if (num[i] == w || num[i] == w - 1) {
				num[i + 1]++;
			} else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
