package Div1_C_Div2_E;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChocolateBar {
	static int n, m, k;
	static long INF = 1000000000000L;

	static long minMoves(int h, int w) {
		if (h * w == k)
			return 0;
		if (h * w < k)
			return INF;
		long ans = INF, tmp;
		for (int i = 1; i < h; i++) {
			tmp = minMoves(i, w);
			if (tmp != INF) {
				tmp += (1L << w);
				ans = Math.min(ans, tmp);
			}
		}
		for (int i = 1; i < w; i++) {
			tmp = minMoves(h, i);
			if (tmp != INF) {
				tmp += (1L << h);
				ans = Math.min(ans, tmp);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		StringBuffer ans = new StringBuffer();
		while (t-- > 0) {
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
			k = Integer.parseInt(l[2]);
			ans.append(minMoves(n, m) + "\n");
		}
		System.out.print(ans);
	}
}
