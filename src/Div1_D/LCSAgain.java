package Div1_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class LCSAgain {
	static char[] s;
	static int n, m;
	static char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static HashSet<String> ans = new HashSet<>();

	static int count(int c, int sim, boolean ignored, String str) {
		if (c >= n) {
			if (sim == n - 1) {
				return 1;
			}
			return 0;
		}
		int res = 0;
		if (!ignored) {
			for (int i = 0; i < m; i++) {
				if (s[c] - 'a' != i)
					res += count(c + 1, sim, true, str + abc[i]);
			}
		}
		for (int i = 0; i < m; i++) {
			if (s[c] - 'a' == i)
				res += count(c + 1, sim + 1, ignored, str + abc[i]);
			else
				res += count(c + 1, sim, ignored, str + abc[i]);
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		s = bf.readLine().toCharArray();
		System.out.println(count(0, 0, false, ""));
	}
}
