package Div300;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	static StringBuffer sb = new StringBuffer();
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while (n > 0) {
			n = next(n, (n + "").toCharArray());
		}
		System.out.println(count + "\n" + sb);
	}

	private static int next(int num, char[] n) {
		int ans = 1;
		String x = "";
		for (int i = 0; i < n.length; i++) {
			if (n[i] == '0') {
				x += "0";
			} else {
				x += "1";
			}
		}
		sb.append(x + " ");
		count++;
		ans = Integer.parseInt(x);
		return num - ans;
	}
}
