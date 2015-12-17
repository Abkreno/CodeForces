package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bits {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			sb.append(popCount(Long.parseLong(l[0]), Long.parseLong(l[1]))
					+ "\n");
		}
		System.out.print(sb);
	}

	private static long popCount(long a, long b) {
		long tmp;
		long ans = b;
		int maxC = Long.bitCount(b);
		int c;
		for (int i = 62; i >= 0; i--) {
			if (((1L << i) & b) > 0) {
				tmp = (b ^ (1L << i)) | ((1L << i) - 1);
				// String s = Long.toBinaryString(tmp);
				if (tmp >= a) {
					c = Long.bitCount(tmp);
					if (c > maxC || (c == maxC && tmp < ans)) {
						maxC = c;
						ans = tmp;
					}
				}
			}
		}
		return ans;
	}
}
