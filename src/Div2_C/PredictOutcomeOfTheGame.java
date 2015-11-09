package Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PredictOutcomeOfTheGame {
	static long[] arr = new long[3];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		String[] l;
		long n, k, a, b;
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < t; i++) {
			l = bf.readLine().split(" ");
			n = Long.parseLong(l[0]);
			k = Long.parseLong(l[1]);
			a = Long.parseLong(l[2]);
			b = Long.parseLong(l[3]);
			if (can(n - k, a, b, k) || can2(n - k, a, b, k)
					|| can3(n - k, a, b, k) || can4(n - k, a, b, k)) {
				ans.append("yes\n");
			} else {
				ans.append("no\n");
			}
		}
		System.out.print(ans);
	}

	private static boolean can(long diff, long a, long b, long k) {
		arr[0] = (k - a - b) / 3;
		arr[1] = arr[0] + a;
		arr[2] = arr[0] + b;
		return test(diff, k);
	}

	private static boolean can4(long diff, long a, long b, long k) {
		arr[0] = (k - a + b) / 3;
		arr[1] = arr[0] + a;
		arr[2] = arr[0] - b;
		return test(diff, k);
	}

	private static boolean can2(long diff, long a, long b, long k) {
		arr[0] = (k + a - b) / 3;
		arr[1] = arr[0] - a;
		arr[2] = arr[0] + b;
		return test(diff, k);
	}

	private static boolean can3(long diff, long a, long b, long k) {
		arr[0] = (k + a + b) / 3;
		arr[1] = arr[0] - a;
		arr[2] = arr[0] - b;
		return test(diff, k);
	}

	private static boolean test(long diff, long k) {
		if (arr[0] < 0 || arr[1] < 0 || arr[2] < 0)
			return false;
		if (arr[0] + arr[1] + arr[2] != k)
			return false;
		Arrays.sort(arr);
		long need = arr[2] - arr[0] + arr[2] - arr[1];
		if (diff < need)
			return false;
		diff -= need;
		return diff % 3 == 0;
	}

}
