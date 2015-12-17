package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matrix {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(bf.readLine());
		char[] s = bf.readLine().toCharArray();
		int n = s.length;
		int arr[] = new int[9 * n + 1];
		int sums[][] = new int[n][n];
		sums[0][0] = s[0] - '0';
		arr[sums[0][0]]++;
		for (int i = 1; i < n; i++) {
			sums[0][i] = s[i] - '0' + sums[0][i - 1];
			arr[sums[0][i]]++;
		}
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				sums[i][j] = sums[i - 1][j] - sums[i - 1][i - 1];
				arr[sums[i][j]]++;
			}
		}
		long res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (a == 0) {
					if (sums[i][j] == 0)
						res += n * (n + 1) / 2;
					else
						res += arr[0];
				} else if (sums[i][j] != 0 && a % sums[i][j] == 0) {
					if (a / sums[i][j] <= 9 * n)
						res += arr[a / sums[i][j]];
				}
			}
		}
		System.out.println(res);
	}
}
