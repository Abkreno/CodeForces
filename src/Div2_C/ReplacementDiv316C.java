package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReplacementDiv316C {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		char[] c = bf.readLine().toCharArray();
		int res = 0;
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == '.' && c[i] == c[i + 1])
				res++;
		}
		int idx;
		char x;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			idx = Integer.parseInt(l[0]) - 1;
			x = l[1].charAt(0);
			if (x == '.') {
				if (c[idx] != '.') {
					if (idx > 0 && c[idx - 1] == '.')
						res++;
					if (idx < n - 1 && c[idx + 1] == '.')
						res++;
				}
			} else {
				if (c[idx] == '.') {
					if (idx > 0 && c[idx - 1] == '.')
						res--;
					if (idx < n - 1 && c[idx + 1] == '.')
						res--;
				}
			}
			c[idx] = x;
			sb.append(res + "\n");
		}
		System.out.print(sb);
	}
}
