package Div2_C;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PocketBox {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		char[][] names = new char[n][];
		for (int i = 0; i < n; i++) {
			names[i] = bf.readLine().toCharArray();
		}
		boolean[] abc = new boolean[26];
		long res = 1;
		long mod = 1000000007;
		for (int i = 0; i < m; i++) {
			Arrays.fill(abc, false);
			long cnt = 0;
			for (int j = 0; j < n; j++) {
				if (!abc[names[j][i] - 'A']) {
					abc[names[j][i] - 'A'] = true;
					cnt++;
				}
			}
			res = ((res % mod) * cnt) % mod;
		}
		System.out.println(res);
	}
}
