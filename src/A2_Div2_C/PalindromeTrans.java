package A2_Div2_C;
import java.util.Scanner;

public class PalindromeTrans {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt() - 1;
		p = Math.min(p, (n - 1) - p);
		sc.nextLine();
		char[] arr = sc.nextLine().toCharArray();
		int res = 0;
		int minInd = n;
		int maxInd = -1;
		for (int i = 0; i < n / 2 + n % 2; i++) {
			if (arr[i] != arr[(n - 1) - i]) {
				if (i != p) {
					minInd = Math.min(minInd, i);
					maxInd = Math.max(maxInd, i);
				}
				res += minVal(arr[i], arr[(n - 1) - i]);
			}
		}
		int dist1 = n;
		int dist2 = n;
		if (maxInd != -1 && maxInd > p) {
			dist1 = maxInd - p;
		}
		if (minInd != n && minInd < p) {
			dist2 = p - minInd;
		}
		if (dist1 < dist2) {
			res += (dist1);
			if (dist2 != n)
				res += dist2+dist1;
		} else if (dist2 != n) {
			res += (dist2);
			if (dist1 != n)
				res += dist1+dist2;
		}
		System.out.println(res);
	}

	private static int minVal(char c, char d) {
		int c1 = c - 'a';
		int d1 = d - 'a';
		return Math.min(Math.abs(c1 - d1),
				26 - Math.max(c1, d1) + Math.min(c1, d1));
	}
}
