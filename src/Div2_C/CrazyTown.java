package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CrazyTown {
	static double eps = 1e-10;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		long x1 = Integer.parseInt(l[0]);
		long y1 = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		long x2 = Integer.parseInt(l[0]);
		long y2 = Integer.parseInt(l[1]);
		int ans = 0;
		long a, b, c;
		boolean v;
		int n = Integer.parseInt(bf.readLine());
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[0]);
			b = Integer.parseInt(l[1]);
			c = Integer.parseInt(l[2]);
			v = x1 * a + y1 * b + c < 0;
			v ^= (x2 * a + y2 * b + c) < 0;
			if (v)
				ans++;
		}
		System.out.println(ans);
	}

}
