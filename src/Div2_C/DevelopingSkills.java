package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DevelopingSkills {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		Integer nums[] = new Integer[n];
		l = bf.readLine().split(" ");
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				int diff1 = diff(n1);
				int diff2 = diff(n2);
				if (diff1 < diff2)
					return -1;
				if (diff1 > diff2)
					return 1;
				return 0;
			}

		});
		int diff;
		long res = 0;
		for (int i = 0; i < nums.length; i++) {
			diff = diff(nums[i]);
			if (diff > k || nums[i] == 100) {
				res += nums[i] / 10;
			} else {
				k -= diff;
				res += (nums[i] + diff) / 10;
				nums[i] += diff;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] + 10 <= 100 && k >= 10) {
				res++;
				k -= 10;
				nums[i] += 10;
			}
		}

		System.out.println(res);
	}

	private static int diff(Integer n1) {
		return 10 - (n1 % 10);
	}
}
