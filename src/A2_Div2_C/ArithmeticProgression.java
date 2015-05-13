package A2_Div2_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class ArithmeticProgression {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		Arrays.sort(nums);
		HashSet<Integer> answer = new HashSet<>();
		if (n == 1) {
			System.out.println(-1);
		} else if (n == 2) {
			if ((nums[1] - nums[0]) % 2 == 0) {
				answer.add(nums[0] - (nums[1] - nums[0]));
				answer.add((nums[1] - nums[0]) / 2 + nums[0]);
				answer.add(nums[1] + (nums[1] - nums[0]));
			} else {
				answer.add((nums[0] - (nums[1] - nums[0])));
				answer.add((nums[1] + (nums[1] - nums[0])));
			}
		} else {
			int diff = nums[1] - nums[0];
			int diff2 = -1;
			int count = 0;
			int index = 0;
			boolean invalid = false;
			for (int i = 1; i < n - 1; i++) {
				if (nums[i + 1] - nums[i] != diff) {
					if (diff2 != -1 && diff2 != nums[i + 1] - nums[i]) {
						invalid = true;
						break;
					} else {
						diff2 = nums[i + 1] - nums[i];
						count++;
						index = i;
					}
				}
			}
			if (invalid) {
				System.out.println(0);
			} else if (count == 0) {
				answer.add(nums[0] - diff);
				answer.add(nums[n - 1] + diff);
			} else if (count == 1 && (nums[index + 1] - nums[index]) % 2 == 0
					&& ((nums[index + 1] - nums[index]) / 2 == diff)) {
				System.out.println("1\n"
						+ ((nums[index + 1] - nums[index]) / 2 + nums[index]));
			} else if (count == n - 2 && diff % 2 == 0 && (diff) / 2 == diff2) {
				System.out.println("1\n" + ((diff) / 2 + nums[0]));
			} else {
				System.out.println(0);
			}
		}
		if (answer.size() > 0) {
			Object[] arr = answer.toArray();
			Arrays.sort(arr);
			System.out.println(arr.length);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
