import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ModuloSum {
	static int[] nums = new int[1000000];
	static int n, m;
	static int DP[][] = new int[1001][1001];

	static boolean go(int i, int mod) {
		if (mod == 0)
			return true;
		if (i >= m)
			return false;
		if (DP[i][mod] != 0)
			return DP[i][mod] == 1 ? true : false;
		boolean ans = go(i + 1, mod) | go(i + 1, (mod + nums[i]) % m);
		DP[i][mod] = ans ? 1 : 2;
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		n = Integer.parseInt(l[0]);
		m = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");

		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		for (int i = 0; i < n; i++) {
			if (go(i + 1, nums[i] % m)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}