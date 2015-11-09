package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class PrimeSwaps {
	static LinkedList<Integer> primes = new LinkedList<>();
	static boolean[] isPrime = new boolean[200002];

	static void sieve() {
		int N = 200001;

		// initially assume all integers are prime
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

		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				primes.add(i);
		}
	}

	public static void main(String[] args) throws Exception {
		sieve();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int index[] = new int[n + 1];
		int nums[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(l[i - 1]);
			index[nums[i]] = i;
		}
		int swaps = 0, tmp;
		StringBuffer ans = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			int curr = index[i];
			if (i == nums[i])
				continue;
			while (!isPrime[curr - i + 1]) {
				int next = i + 1;
				while (!isPrime[curr - next + 1])
					next++;
				index[nums[next]] = curr;
				index[i] = i;
				tmp = nums[next];
				nums[next] = nums[curr];
				nums[curr] = tmp;
				ans.append(next + " " + curr + "\n");
				swaps++;
				curr = next;
			}
			index[nums[i]] = curr;
			index[i] = i;
			tmp = nums[i];
			nums[i] = nums[curr];
			nums[curr] = tmp;
			ans.append(i + " " + curr + "\n");
			swaps++;
		}
		System.out.println(swaps);
		System.out.print(ans);
	}
}
