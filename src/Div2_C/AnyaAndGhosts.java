package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AnyaAndGhosts {
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int m = Integer.parseInt(l[0]);
		int t = Integer.parseInt(l[1]);
		int r = Integer.parseInt(l[2]);
		int time[] = new int[601];
		l = bf.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			time[Integer.parseInt(l[i]) + 300] = r;
		}
		int candles = 0;
		for (int i = Integer.parseInt(l[0]); i < time.length; i++) {
			if (time[i] > 0) {
				candles += time[i];
				for (int j = i - time[i]; j < i; j++) {
					for (int k = j + 1; k <= j + t && k < time.length; k++) {
						time[k]--;
					}
				}
			}
		}
		for (int i = Integer.parseInt(l[0]); i < time.length; i++) {
			if (time[i] > 0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(candles);
	}
}
