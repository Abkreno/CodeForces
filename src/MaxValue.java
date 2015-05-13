import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxValue {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] nums = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums);
		int max = nums[n - 1];
		for (int i = 0; i < n - 1; i++) {
			nums[i] = max - (max % nums[i]);
		}
		Arrays.sort(nums);
		System.out.println(nums[n - 1] - nums[0]);
	}
}
