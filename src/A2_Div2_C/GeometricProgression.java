package A2_Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class GeometricProgression {
	static class N {
		long count1, count2;

		N() {
			count1 = 0;
			count2 = 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		if (k == 1) {
			solveOne(n, k, bf);
			return;
		}
		HashMap<Integer, N> counts = new HashMap<>();
		l = bf.readLine().split(" ");
		int curr, currk;
		N prev, c;
		long ans = 0, zeros = 0;
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			if (curr == 0) {
				zeros++;
				continue;
			}
			if (!counts.containsKey(curr)) {
				counts.put(curr, new N());
			}
			c = counts.get(curr);
			c.count1++;

			currk = curr % k == 0 ? curr / k : 0;

			if (currk != 0 && counts.containsKey(currk)) {
				prev = counts.get(currk);
				c.count2 += prev.count1;
				ans += prev.count2;
			}
		}
		System.out.println(ans + nCk(zeros, 3));
	}

	private static void solveOne(int n, int k, BufferedReader bf)
			throws IOException {
		String[] l = bf.readLine().split(" ");
		int curr;
		HashMap<Integer, Long> counts = new HashMap<>();
		for (int i = 0; i < l.length; i++) {
			curr = Integer.parseInt(l[i]);
			if (!counts.containsKey(curr)) {
				counts.put(curr, 0L);
			}
			counts.put(curr, counts.get(curr) + 1);
		}
		long ans = 0;
		long s;
		Iterator it = counts.keySet().iterator();
		while (it.hasNext()) {
			s = counts.get(it.next());
			ans += nCk(s, 3);
		}
		System.out.println(ans);
	}

	static long nCk(long n, long k) {
		if (k > n)
			return 0;
		if (k * 2 > n)
			k = n - k;
		if (k == 0)
			return 1;

		long result = n;
		for (long i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

}