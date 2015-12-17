package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrGame {
	static int n, k;
	static long x;
	static long prev[] = new long[200005];
	static long next[] = new long[200005];
	static long nums[] = new long[200005];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String l[] = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		k = Integer.parseInt(l[1]);
		x = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		for (int i = 1; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i - 1]);
		}
		long p = 1;
		for (int i = 1; i <= k; i++)
			p *= x;
		for (int i = 1; i <= n; i++) {
			prev[i] = nums[i] | prev[i - 1];
		}
		for (int i = n; i > 0; i--) {
			next[i] = nums[i] | next[i + 1];
		}
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, (nums[i] * p) | prev[i - 1] | next[i + 1]);
		}
		System.out.println(ans);
	}
}
