

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SchoolMarks {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int p = Integer.parseInt(l[2]);
		int x = Integer.parseInt(l[3]);
		int y = Integer.parseInt(l[4]);
		int nums[] = new int[k];
		l = bf.readLine().split(" ");
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			sum += nums[i];
		}
		if (sum > x) {
			System.out.println(-1);
			return;
		}
		if (k == 0) {
			if ((y * ((n / 2) + 1)) + (n / 2) <= x) {
				for (int j = 0; j < n / 2; j++) {
					System.out.print(1 + " ");
				}
				for (int j = 0; j <= n / 2; j++) {
					System.out.print(y + " ");
				}
			} else {
				System.out.println(-1);
			}
			return;
		}
		Arrays.sort(nums);

		int need, right, left, rl = n / 2;
		int pos = -1;
		boolean f = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < y)
				continue;
			if (pos == -1)
				pos = i;
			if (nums[i] == y)
				f = false;
			right = k - i - 1;
			if (right > rl)
				continue;
			need = (rl - right) * nums[i];
			left = i;
			if (left > rl)
				continue;
			need += (rl - left);
			if (need + sum > x)
				continue;
			for (int j = 0; j < rl - left; j++) {
				System.out.print(1 + " ");
			}
			for (int j = 0; j < rl - right; j++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		if (f) {
			if (pos == -1)
				pos = k;
			
			k += 1;
			if (k > n) {
				System.out.println(-1);
				return;
			}
			sum += y;
			right = k - pos - 1;
			if (right > rl) {
				System.out.println(-1);
				return;
			}
			need = (rl - right) * y;
			left = pos;
			if (left > rl) {
				System.out.println(-1);
				return;
			}
			need += (rl - left);
			if (need + sum > x) {
				System.out.println(-1);
				return;
			}
			for (int j = 0; j < rl - left; j++) {
				System.out.print(1 + " ");
			}
			for (int j = 0; j <= rl - right; j++) {
				System.out.print(y + " ");
			}
			System.out.println();
			return;
		}
		System.out.println(-1);
	}
}
