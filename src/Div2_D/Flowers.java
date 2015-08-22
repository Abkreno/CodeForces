package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Flowers {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int t = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		long DP[] = new long[100001];
		long mod = 1000000007;
		DP[0] = 1;
		for (int i = 1; i < DP.length; i++) {
			DP[i] = DP[i - 1];
			DP[i] %= mod;
			if (i - k >= 0) {
				DP[i] += DP[i - k];
				DP[i] %= mod;
			}
		}
		for (int i = 1; i < DP.length; i++) {
			DP[i] += DP[i - 1];
		}
		StringBuffer sb = new StringBuffer();
		long curr;
		for (int i = 0; i < t; i++) {
			l = bf.readLine().split(" ");
			curr = DP[Integer.parseInt(l[1])] - DP[Integer.parseInt(l[0]) - 1];
			curr %= mod;
			sb.append(curr + "\n");
		}
		System.out.print(sb);
	}
}
