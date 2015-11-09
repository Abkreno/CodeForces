package Div324;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		long ans = 1;
		long diff = 1;
		long mod = 1000000007;
		for (int i = 0; i < n; i++) {
			ans *= 27;
			ans %= mod;
			diff *= 7;
			diff %= mod;
		}
		ans -= diff;
		if (ans < 0)
			ans += mod;
		System.out.println(ans);
	}
}
