import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Div248B {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		long nums[] = new long[n];
		long sums[] = new long[n + 1];
		long sums2[] = new long[n + 1];
		for (int i = 0; i < n; i++) {
			long curr = Integer.parseInt(l[i]);
			nums[i] = curr;
			sums[i + 1] = curr + sums[i];
		}
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			sums2[i + 1] = nums[i] + sums2[i];
		}
		StringBuffer ans = new StringBuffer();
		int m = Integer.parseInt(bf.readLine()), a, b;
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			a = Integer.parseInt(l[1]);
			b = Integer.parseInt(l[2]);
			if (l[0].charAt(0) == '1') {
				ans.append(sums[b] - sums[a - 1]);
			} else {
				ans.append(sums2[b] - sums2[a - 1]);
			}
			ans.append("\n");
		}
		System.out.print(ans);
	}
}
