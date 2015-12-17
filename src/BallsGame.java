import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BallsGame {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int x = Integer.parseInt(l[2]);
		l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int j, p1, p2;
		int maxScore = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == x && i == 0 || (i > 0 && nums[i - 1] != x)) {
				for (j = i; j < nums.length && nums[j] == x; j++) {
				}
				if (j == nums.length || nums[j] != x)
					j--;
				if (j - i + 1 < 2)
					continue;
				p1 = i - 1;
				p2 = j + 1;
				if (p1 < 0 || p2 >= nums.length || nums[p1] != nums[p2]) {
					maxScore = Math.max(maxScore, j - i + 1);
					continue;
				}
				int currCount = 2;
				while (true) {
					if (p1 - 1 >= 0 && nums[p1 - 1] == nums[p2]) {
						currCount++;
						p1--;
					} else if (p2 + 1 < n && nums[p2 + 1] == nums[p1]) {
						currCount++;
						p2++;
					} else if (currCount > 2 && p1 - 1 >= 0 && p2 + 1 < n
							&& nums[p1 - 1] == nums[p2 + 1]) {
						p1--;
						p2++;
						currCount = 2;
					} else {
						break;
					}
				}
				if (currCount == 2) {
					p2--;
					p1++;
				}
				maxScore = Math.max(p2 - p1 + 1, maxScore);
			}
		}
		System.out.println(maxScore);
	}
}
