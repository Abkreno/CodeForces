package Div284;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		char c[][] = new char[n][];
		for (int i = 0; i < n; i++) {
			c[i] = bf.readLine().toCharArray();
		}
		int ans = 0;
		boolean removed[] = new boolean[c[0].length];
		for (int i = 0; i < c.length - 1; i++) {
			for (int j = 0; j < c[0].length; j++) {
				if (removed[j])
					continue;
				if (c[i][j] > c[i + 1][j]) {
					removed[j] = true;
					i = -1;
					break;
				} else if (c[i][j] < c[i + 1][j]) {
					break;
				}
			}
		}
		for (int i = 0; i < removed.length; i++) {
			if (removed[i])
				ans++;
		}
		System.out.println(ans);
	}

}
