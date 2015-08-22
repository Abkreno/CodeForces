package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Present {
	static int n, m, w, nums[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] l = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		w = Integer.parseInt(l[2]);
		nums = new int[n];
		l = bf.readLine().split(" ");
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			min = Math.min(nums[i], min);
		}
		long lo = 1, hi = 1000100000, mid, x = min;
		while (lo <= hi) {
			mid = (lo + hi) >> 1;
			if (check(mid)) {
				x = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(x);
	}

	static boolean check(long mid) {
		int prev[] = new int[n];
		int add = 0;
		int waters = m;
		for (int i = 0; i < n; i++) {
			if (nums[i] + add < mid) {
				prev[i] = (int) (mid - (nums[i] + add));
				waters -= prev[i];
				if (waters < 0)
					return false;
				add += prev[i];
			}

			if (i - w + 1 >= 0)
				add -= prev[i - w + 1];
		}
		return true;
	}

}
