import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div331B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		long steps = 0;
		long max = 0;
		long nums[] = new long[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			if (nums[i] > max) {
				steps += nums[i] - max;
				max = nums[i];
			} else if (nums[i] < max) {
				steps += max - nums[i];
				max = nums[i];
			}
		}
		System.out.println(steps);
	}
}
