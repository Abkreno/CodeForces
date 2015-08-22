import java.util.Arrays;
import java.util.Scanner;

public class PreparingOlympiad {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int x = sc.nextInt();
		int c[] = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		Arrays.sort(c);
		int prev, totalDiff, first, last;
		int ans = 0;
		boolean ok;
		for (int i = 0; i < 1 << n; i++) {
			prev = 0;
			ok = true;
			totalDiff = 0;
			first = 0;
			last = 0;
			for (int j = 0; j < n; j++) {
				if (((1 << j) & i) > 0) {
					if (prev == 0) {
						first = last = c[j];
					} else {
						last = c[j];
					}
					totalDiff += c[j];
					prev = c[j];
				}
			}
			if (totalDiff >= l && totalDiff <= r && last - first >= x) {
				ans += ok ? 1 : 0;
			}
		}
		System.out.println(ans);
	}
}
