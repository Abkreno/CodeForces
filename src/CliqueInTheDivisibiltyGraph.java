import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CliqueInTheDivisibiltyGraph {
	static BufferedReader bf;
	static boolean nums[] = new boolean[1000001];
	static int DP[] = new int[1000001];

	int getMax(int curr) {
		if (curr >= nums.length)
			return 0;
		if (DP[curr] != -1)
			return DP[curr];
		int max = 0;
		for (int j = 2; j * curr < nums.length; j++) {
			if (nums[j * curr]) {
				max = Math.max(max, getMax(j * curr));
			}
		}
		return DP[curr] = max + 1;
	}

	void solve() throws Exception {
		Arrays.fill(DP, -1);
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[Integer.parseInt(l[i])] = true;
		}
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i])
				max = Math.max(max, getMax(i));
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			new CliqueInTheDivisibiltyGraph().solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
