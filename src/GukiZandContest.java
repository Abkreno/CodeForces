import java.util.Arrays;
import java.util.Scanner;

public class GukiZandContest {
	static boolean flag = false;

	static class st implements Comparable<st> {
		int i, j, c;

		st(int ind, int s) {
			i = ind;
			j = s;
		}

		@Override
		public int compareTo(st o) {
			if (flag)
				return i - o.i > 0 ? 1 : i - o.i == 0 ? 0 : -1;
			return j - o.j > 0 ? 1 : j - o.j == 0 ? 0 : -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		st[] nums = new st[n];
		for (int i = 0; i < n; i++) {
			nums[i] = new st(i + 1, sc.nextInt());
		}
		Arrays.sort(nums);
		int count = 1;
		nums[n - 1].c = 1;
		int max = nums[n - 1].j;
		int diff = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i].j == max) {
				nums[i].c = count;
				diff++;
			} else {
				max = nums[i].j;
				nums[i].c = diff + (++count);
				count = nums[i].c;
				diff = 0;
			}
		}
		flag = true;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i].c + " ");
		}
		System.out.println();
	}
}
