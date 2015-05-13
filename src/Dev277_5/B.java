package Dev277_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int nums[] = new int[n];
		String[] l = bf.readLine().split(" ");
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int k = 0;
		for (int i = 0; i < n; i++) {
			int min = nums[i];
			int bestIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < min) {
					min = nums[j];
					bestIndex = j;
				}
			}
			if (bestIndex != i) {
				k++;
				ans.append(bestIndex + " " + i + '\n');
			}
			int temp = nums[i];
			nums[i] = nums[bestIndex];
			nums[bestIndex] = temp;
		}
		System.out.println(k);
		if (k != 0)
			System.out.println(ans);
	}
}
