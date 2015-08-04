package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WritingCode {
	static int[] a;
	static int n, m, b, mod;
	static int DP[][] = new int[511][511];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		b = Integer.parseInt(l[2]);
		mod = Integer.parseInt(l[3]);
		a = new int[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
		DP[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int lines = 0; lines <= m; lines++) {
				for (int j = 0; j + a[i - 1] <= b; j++) {
					DP[lines + 1][j + a[i - 1]] += DP[lines][j];
					DP[lines + 1][j + a[i - 1]] %= mod;
				}
			}
		}
		int res = 0;
		for (int i = 0; i <= b; i++) {
			res += DP[m][i];
			res %= mod;
		}
		System.out.println(res);
	}
}
