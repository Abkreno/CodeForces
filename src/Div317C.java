import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div317C {
	static int[] nums;
	static long DP[][][] = new long[3][100001][2];
	static int totalSum;

	static long count(int curr, int l) {
		if (curr > 2)
			return 0;
		long ans = valid(nums[0], nums[1], nums[2]) ? 1 : 0;
		// boolean valid = ans == 1 ? true : false;
		if (l <= 0)
			return ans;
		int otherSum = nums[0] + nums[1] + nums[2] - nums[curr];
		for (int i = 0; i <= l; i++) {
			if (nums[curr] + i > l + otherSum)
				break;
			nums[curr] += i;
			ans += count(curr + 1, l - i);
			nums[curr] -= i;
		}
		return ans;
	}

	private static boolean valid(int a, int b, int c) {
		return a + b > c && b + c > a && c + a > b;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < DP[i].length; j++) {
				Arrays.fill(DP[i][j], -1);
			}
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		nums = new int[3];
		nums[0] = Integer.parseInt(l[0]);
		nums[1] = Integer.parseInt(l[1]);
		nums[2] = Integer.parseInt(l[2]);
		Arrays.sort(nums);
		int len = Integer.parseInt(l[3]);
		int ans = 0;
		for (int i = 0; i <= len; i++) {
			if (len - i + nums[1] + nums[2] < nums[0] + i)
				break;
			nums[0] += i;
			for (int j = 0; j + i <= len; j++) {
				if (len - i - j + nums[2] + nums[0] < nums[1])
					break;
				if (len - i - j + nums[2] + nums[1] < nums[0])
					break;
				nums[1] += j;
				for (int k = 0; k + i + j <= len; k++) {
					nums[2] += k;
					if (valid(nums[0], nums[1], nums[2]))
						ans++;
				nums[2] -= k;
				}
				nums[1] -= j;
			}
			nums[0] -= i;
		}
		System.out.println(ans);

	}
}
