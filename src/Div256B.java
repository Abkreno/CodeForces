import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Div256B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		boolean f = true;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				f = false;
				break;
			}
		}
		if (f) {
			System.out.println(0);
			return;
		}
		int leftMost = nums[0];
		int shifts = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] <= leftMost) {
				leftMost = nums[i];
				shifts++;
			} else {
				for (int j = 0; j < i; j++) {
					if (nums[j] > nums[j + 1]) {
						System.out.println(-1);
						return;
					}
				}
				System.out.println(shifts);
				return;
			}
		}
		System.out.println(shifts);
	}
}
