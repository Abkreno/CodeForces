package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoundTableKnights {
	static int n;
	static boolean in[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		boolean allOnes = true;
		in = new boolean[n];
		for (int i = 0; i < l.length; i++) {
			if (l[i].equals("1"))
				in[i] = true;
			else
				allOnes = false;
		}
		if (allOnes) {
			System.out.println("YES");
		} else {
			int shift = -1, best = -1;
			for (int i = 3; i <= n; i++) {
				if ((n - i) % i == 0) {
					shift = (n - i) / i;
					best = i;
					if (test(shift, best)) {
						System.out.println("YES");
						break;
					} else {
						shift = -1;
					}
				}
			}
			if (shift == -1)
				System.out.println("NO");
		}
	}

	static boolean test(int shift, int best) {
		for (int i = 0; i < n; i++) {
			int j = 0;
			boolean f = true;
			int curr = i;
			while (j < best) {
				if (!in[curr]) {
					f = false;
					break;
				}
				curr = (curr + shift + 1) % n;
				j++;
			}
			if (f) {
				return true;
			}
		}
		return false;
	}
}
