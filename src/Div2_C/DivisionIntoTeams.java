package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DivisionIntoTeams {
	static class Int implements Comparable<Int> {
		int val, index;

		Int(int i, int v) {
			val = v;
			index = i + 1;
		}

		@Override
		public int compareTo(Int o) {
			if (o.val < val)
				return 1;
			if (o.val > val)
				return -1;
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		Int nums[] = new Int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Int(i, Integer.parseInt(l[i]));
		}
		Arrays.sort(nums);
		StringBuffer t1 = new StringBuffer();
		StringBuffer t2 = new StringBuffer();
		if (n % 2 == 1) {
			t1.append(nums[0].index + " ");
		}
		for (int i = n % 2; i < n; i += 2) {
			t1.append(nums[i].index + " ");
			t2.append(nums[i + 1].index + " ");
		}

		System.out.println(n / 2);
		System.out.println(t2);
		System.out.println(n / 2 + n % 2);
		System.out.println(t1);

	}
}
