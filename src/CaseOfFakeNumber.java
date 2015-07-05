import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CaseOfFakeNumber {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		boolean good = true;
		for (int i = 0; i <= n; i++) {
			int curr = 0;
			boolean clock = true;
			good = true;
			for (int j = 0; j < nums.length; j++) {
				if (clock) {
					nums[j] = (nums[j] + 1) % (n);
				} else {
					nums[j] = (nums[j] - 1) < 0 ? n - 1 : nums[j] - 1;
				}
				if (nums[j] != curr++) {
					good = false;
				}
				clock = !clock;
			}
			if (good) {
				System.out.println("Yes");
				break;
			}

		}
		if (!good)
			System.out.println("No");
	}
}
