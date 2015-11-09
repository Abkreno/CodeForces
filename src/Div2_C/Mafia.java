package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mafia {
	static int nums[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		nums = new int[n];
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums);
		long lo = 0;
		long hi = 2000000000;
		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (mid >= nums[n - 1] && check(mid)) {
				hi = mid;
			} else {
				lo = mid;
			}
		}
		System.out.println(hi);
	}

	static boolean check(long rounds) {
		long neededSup = rounds;
		for (int i = 0; i < nums.length; i++) {
			long availble = rounds - nums[i];
			if (availble < 0)
				return false;
			neededSup -= availble;
			if (neededSup <= 0)
				return true;
		}
		return neededSup <= 0;
	}
}
