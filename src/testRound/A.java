package testRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Vector;

public class A {
	static long nCk(long n, long k) {
		if (k > n)
			return 0;
		if (k * 2 > n)
			k = n - k;
		if (k == 0)
			return 1;

		long result = n;
		for (int i = 2; i <= k; ++i) {
			result *= (n - i + 1);
			result /= i;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int[] A = new int[n];
		int k = Integer.parseInt(l[1]);
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(bf.readLine());
		}
		int[] P = new int[n + 1];
		int res = 0;
		Vector<Integer> L = new Vector<Integer>();
		for (int i = 0; i < n; ++i) {
			int pos = Collections.binarySearch(L, A[i]);
			if (pos < 0)
				pos = -(pos + 1); // some adjustments are needed
			if (pos >= L.size())
				L.add(A[i]);
			else
				L.set(pos, A[i]);
			if (pos + 1 > k) {
				System.out.println((pos + 1));
				res += nCk(pos + 1, k + 1);
			}
		}
		System.out.println(res);

	}
}
