package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MashmokhAndNumbers {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		if (k < n / 2)
			System.out.println(-1);
		else if (n == 1) {
			System.out.println(k == 0 ? 1 : -1);
		} else {
			int a = k - ((n - 2) / 2);
			int b = a * 2;
			StringBuffer sb = new StringBuffer();
			sb.append(a + " " + b + " ");
			int c = 2;
			for (int i = b + 1; c++ < n; i++) {
				sb.append(i + " ");
			}
			System.out.println(sb);
		}
	}
}
