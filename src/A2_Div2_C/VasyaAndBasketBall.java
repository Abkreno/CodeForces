package A2_Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VasyaAndBasketBall {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < l.length; i++) {
			a[i] = Integer.parseInt(l[i]);
		}
		int m = Integer.parseInt(bf.readLine());
		int[] b = new int[m];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			b[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int bestA = n * 3;
		int ind = higherBound(b, a[0] - 1);
		int bestB = ((m - ind) * 3) + (ind * 2);
		int currA, currB;
		for (int i = 0; i < n; i++) {
			if (i + 1 != n && a[i] == a[i + 1])
				continue;
			currA = ((i + 1) * 2) + ((n - i - 1) * 3);
			ind = higherBound(b, a[i]);
			currB = (m - ind) * 3 + ind * 2;
			if (currA - currB > bestA - bestB) {
				bestA = currA;
				bestB = currB;
			}
		}

		for (int i = 0; i < m; i++) {
			if (i + 1 != m && b[i] == b[i + 1])
				continue;
			currB = ((i + 1) * 2) + ((m - i - 1) * 3);
			ind = higherBound(a, b[i]);
			currA = (n - ind) * 3 + ind * 2;
			if (currA - currB > bestA - bestB) {
				bestA = currA;
				bestB = currB;
			}
		}

		if (n * 2 - m * 2 > bestA - bestB) {
			bestA = n * 2;
			bestB = m * 2;
		}
		System.out.println(bestA + ":" + bestB);
	}

	static int higherBound(int[] arr, int key) {
		// First index greater than key
		int lo = -1;
		int hi = arr.length;
		int mid;
		while (lo + 1 < hi) {
			mid = (lo + hi) >> 1;
			if (arr[mid] > key) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		return hi;
	}
}
