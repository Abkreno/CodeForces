import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PiA {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int nums[] = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		StringBuffer ans = new StringBuffer();
		int min, max;
		for (int i = 0; i < n; i++) {
			min = Integer.MAX_VALUE;
			if (i != 0)
				min = nums[i] - nums[i - 1];
			if (i + 1 != n)
				min = Math.min(min, nums[i + 1] - nums[i]);

			max = Integer.MIN_VALUE;
			if (i != n - 1)
				max = nums[n - 1] - nums[i];
			if (i != 0)
				max = Math.max(max, nums[i] - nums[0]);
			ans.append(min + " " + max + "\n");
		}
		System.out.print(ans);

	}
}
