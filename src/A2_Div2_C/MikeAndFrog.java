package A2_Div2_C;

import java.util.Arrays;
import java.util.Scanner;

public class MikeAndFrog {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		long h1 = sc.nextInt();
		long a1 = sc.nextInt();
		long x1 = sc.nextInt();
		long y1 = sc.nextInt();
		long h2 = sc.nextInt();
		long a2 = sc.nextInt();
		long x2 = sc.nextInt();
		long y2 = sc.nextInt();
		int visited[] = new int[m + 1];

		Arrays.fill(visited, -1);
		long len1 = 0;
		long showedAt = -1;
		long period = 0;
		boolean rep1 = false;

		while (true) {
			if (visited[(int) h1] != -1) {
				period = len1 - visited[(int) h1];
				if (showedAt < len1 && showedAt >= visited[(int) h1])
					rep1 = true;
				break;
			}
			visited[(int) h1] = (int) len1;
			if (h1 == a1 && showedAt == -1) {
				showedAt = len1;
			}
			h1 = (x1 * h1 + y1) % m;
			len1++;
		}
		if (showedAt < 0) {
			System.out.println(-1);
			return;
		}

		Arrays.fill(visited, -1);
		long len2 = 0;
		long showedAt2 = -1;
		long period2 = 0;
		boolean rep2 = false;

		while (true) {
			if (visited[(int) h2] != -1) {
				period2 = len2 - visited[(int) h2];
				if (showedAt2 < len2 && showedAt2 >= visited[(int) h2])
					rep2 = true;
				break;
			}
			visited[(int) h2] = (int) len2;
			if (h2 == a2 && showedAt2 == -1) {
				showedAt2 = len2;
			}
			h2 = (x2 * h2 + y2) % m;
			len2++;
		}

		if (showedAt2 < 0) {
			System.out.println(-1);
			return;
		}
		if (showedAt != showedAt2) {
			if ((!rep1 || !rep2)) {
				if (showedAt < showedAt2) {
					if (rep1) {
						long diff = showedAt2 - showedAt;
						if (diff % period == 0)
							showedAt = showedAt2;
					}
				} else {
					if (rep2) {
						long diff = showedAt - showedAt2;
						if (diff % period2 == 0)
							showedAt2 = showedAt;
					}
				}
			} else if (rep1 && rep2) {
				int t = 0;
				while (t++ < 2000000) {
					if (showedAt < showedAt2) {
						long diff = showedAt2 - showedAt;
						if (diff % period == 0) {
							showedAt = showedAt2;
							break;
						}
						showedAt += ((diff / period) + 1) * period;
					} else {
						long diff = showedAt - showedAt2;
						if (diff % period2 == 0) {
							showedAt2 = showedAt;
							break;
						}
						showedAt2 += ((diff / period2) + 1) * period2;
					}
				}
			}
		}
		if (showedAt == showedAt2 && showedAt >= 0) {
			System.out.println(showedAt);
		} else {
			System.out.println(-1);
		}
	}
}
