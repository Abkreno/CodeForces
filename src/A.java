import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
	static int N = 10;
	static int nums[] = new int[N + 1];
	static int sums[] = new int[N + 1];
	static int c[] = new int[N + 1];
	static int cnt[][] = new int[201][N + 1];
	static int INF = 1000;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n, i, j, temp, currCount, neededCount, maxN = 0;
		int currEfort, minEfort = INF;
		n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		for (i = 0; i < n; i++)
			nums[i] = Integer.parseInt(l[i]);
		l = bf.readLine().split(" ");
		for (i = 0; i < n; i++) {
			temp = Integer.parseInt(l[i]);
			maxN = Math.max(maxN, nums[i]);
			sums[nums[i]] += temp;
			c[nums[i]]++;
			cnt[temp][nums[i]]++;
		}
		N = maxN;
		for (i = 1; i <= N; i++) {
			sums[i] += sums[i - 1];
			c[i] += c[i - 1];
		}
		for (i = 1; i <= 200; i++)
			for (j = 1; j <= N; j++)
				cnt[i][j] += cnt[i][j - 1];

		for (int k = 0; k < n; k++) {
			i = nums[k];
			currEfort = sums[N] - sums[i];
			currCount = c[i] - c[i - 1];
			neededCount = (n - (currCount * 2 - 1));
			neededCount -= c[N] - c[i];
			j = 1;
			if(neededCount>0)
			while (j < 201) {
				if (neededCount <= cnt[j][i - 1]) {
					currEfort += neededCount * j;
					neededCount = 0;
					break;
				} else {
					neededCount -= cnt[j][i - 1];
					currEfort += cnt[j][i - 1] * j;
				}
				j++;
			}
			if (neededCount <= 0)
				minEfort = Math.min(minEfort, currEfort);
		}
		System.out.println(minEfort);
	}

	static double eps = 1e-9;

	static int compare(double a, double b) {
		if (Math.abs(a - b) < eps)
			return 0;
		if (a - b < 0.0)
			return -1;
		return 1;
	}
}
