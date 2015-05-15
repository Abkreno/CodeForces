package Div277;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int arr[][] = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(l[j]);
			}
		}
		int res[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(res[i], 1);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					for (int k = 0; k < m; k++) {
						res[i][k] = 0;
					}
					for (int k = 0; k < n; k++) {
						res[k][j] = 0;
					}
				}
			}
		}
		boolean flag = false;
		loop: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				boolean found = false;
				if (arr[i][j] == 1) {
					for (int k = 0; k < m; k++) {
						if (res[i][k] == 1) {
							found = true;
							break;
						}
					}
					for (int k = 0; k < n; k++) {
						if (res[k][j] == 1) {
							found = true;
							break;
						}
					}
				} else {
					found = true;
				}
				if (found == false) {
					flag = true;
					break loop;
				}
			}
		}
		if (flag)
			System.out.println("NO");
		else {
			System.out.println("YES");
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[i].length; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
