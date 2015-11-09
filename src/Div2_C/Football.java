package Div2_C;

import java.util.Scanner;

public class Football {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean played[][] = new boolean[n][n];
		if (k > n) {
			System.out.println(-1);
			return;
		} else {
			StringBuilder sb = new StringBuilder();
			int x, ans = 0;
			for (int i = 1; i <= n; i++) {
				x = 0;
				for (int j = 1; x < k && j <= n; j++) {
					if (j == i || played[i - 1][j - 1]) {
						continue;
					}
					played[i - 1][j - 1] = played[j - 1][i - 1] = true;
					sb.append(i + " " + j + "\n");
					ans++;
					x++;
				}
				if (x != k) {
					System.out.println(-1);
					return;
				}
			}
			System.out.println(ans);
			System.out.print(sb);
		}
	}
}
