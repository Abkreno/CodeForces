package A2_Div2_C;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfWays {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		long nums[] = new long[n];
		String[] l = bf.readLine().split(" ");
		nums[0] = Integer.parseInt(l[0]);
		long S = nums[0];
		for (int i = 1; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			S += nums[i];
		}
		long res = 0;
		if (S % 3 == 0) {
			long S3 = S / 3;
			long[][] DP = new long[3][n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += nums[i];
				if (sum == S3) {
					DP[0][i] = 1;
				}
			}
			for (int i = 1; i < n; i++) {
				DP[1][i] += DP[1][i - 1] + DP[0][i - 1];
			}
			sum = 0;
			for (int i = n - 1; i > 0; i--) {
				sum += nums[i];
				if (sum == S3)
					res += DP[1][i - 1];
			}
		}
		System.out.println(res);
	}
}
