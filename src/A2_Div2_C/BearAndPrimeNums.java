package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BearAndPrimeNums {
	static int N = (int) Math.pow(10, 7);
	static boolean[] isPrime = new boolean[N + 1];
	static int[] primes = new int[664579]; // num of primes till 10000000=664579
	static int[] f = new int[664579];
	static int[] count = new int[N + 1];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] nums = new int[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
			count[nums[i]]++;
		}

		int index = 0;

		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		for (int i = 0; i <= N; i++) {
			if (isPrime[i]) {
				primes[index++] = i;
				for (int j = 1; i * j > 0 && i * j <= N; j++) {
					f[index - 1] += count[i * j];
				}
			}
		}
		for (int i = 1; i < f.length; i++) {
			f[i] += f[i - 1];
		}
		int m = Integer.parseInt(bf.readLine());
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < m; i++) {
			l = bf.readLine().split(" ");
			int low = higherBound(Integer.parseInt(l[0]));
			int hi = lowerBound(Integer.parseInt(l[1]));
			int sum = f[hi];
			if (low > 0)
				sum -= f[low - 1];
			ans.append(sum + "\n");
		}
		System.out.print(ans);
	}

	static int higherBound(int l) {
		int lo = 0;
		int hi = 664579;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (primes[mid] < l) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return hi;
	}

	static int lowerBound(int r) {
		int lo = 0;
		int hi = 664579;
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (primes[mid] <= r) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		return lo;
	}

}
