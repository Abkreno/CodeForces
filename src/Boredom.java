import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boredom {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		long values[] = new long[100000 + 1];
		long DP[][] = new long[2][100000 + 1];
		int nums[] = new int[100000 + 1];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(l[i]);
			values[curr] += curr;
			nums[curr] = curr;
		}
		long max = 0;
		for (int i = 1; i < 100001; i++) {
			DP[1][i] = DP[0][i - 1] + values[i];
			DP[0][i] = Math.max(DP[1][i - 1], DP[0][i - 1]);
			max = Math.max(max, Math.max(DP[1][i], DP[0][i]));
		}
		System.out.println(max);
	}
}
