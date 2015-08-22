package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Robbery {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int k = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		int nums[] = new int[n];
		int movesForOneDiamond = n / 2 + n % 2;
		if (n % 2 == 1 && m >= movesForOneDiamond) {
			int amountInOneMove = m / movesForOneDiamond;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(l[i]);
				min = Math.min(min, i % 2 == 0 ? nums[i] : min);
			}
			int totalTime = min / amountInOneMove;
			int left = min % amountInOneMove;
			long ans = 0;
			if (left > 0 && k > totalTime) {
				ans = left;
			}
			k = Math.min(k, totalTime);
			System.out.println(k * amountInOneMove + ans);
		} else {
			System.out.println(0);
		}

	}
}
