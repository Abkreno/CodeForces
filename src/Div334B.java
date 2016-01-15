import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div334B {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int[] nums = new int[n];
		l = bf.readLine().split(" ");
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			max = Math.max(nums[i], max);
		}
		long lo = 0;
		long mid, hi = 10000000;
		while (lo + 1 < hi) {
			mid = (lo + hi) / 2;
			if (check(mid, k, nums) || check2(mid, k, nums)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		System.out.println(hi);
	}

	private static boolean check2(long mid, int k, int[] nums) {
		int n = nums.length;
		int x = 0;
		for (int i = n - 1; i >= x; i--) {
			if (k == 0 || nums[i] > mid)
				return false;
			if (x < i && nums[i] + nums[x] <= mid) {
				x++;
			}
			k--;
		}
		return true;
	}

	private static boolean check(long mid, int k, int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (k == 0 || nums[i] > mid)
				return false;
			if (i < n - 1 && nums[i] + nums[i + 1] <= mid) {
				i++;
			}
			k--;
		}
		return true;
	}
}
