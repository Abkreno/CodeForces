import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShowerLine {
	static int nums[][] = new int[5][5];
	static int currOrder[] = new int[5];
	static int max = 0;

	static void findMax(int currMask, int i) {
		if (currMask == 31) {
			max = Math.max(max, calc());
			return;
		}
		for (int j = 0; j < 5; j++) {
			if (((1 << j) & currMask) == 0) {
				currOrder[i] = j;
				findMax(currMask | (1 << j), i + 1);
			}
		}
	}

	private static int calc() {
		int res = 0;
		for (int i = 0; i < currOrder.length; i++) {
			for (int j = i; j < currOrder.length-1; j += 2) {
				res += nums[currOrder[j]][currOrder[j + 1]];
				res += nums[currOrder[j + 1]][currOrder[j]];
			}
		}
		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] l;
		for (int i = 0; i < 5; i++) {
			l = bf.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				nums[i][j] = Integer.parseInt(l[j]);
			}
		}
		findMax(0, 0);
		System.out.println(max);
	}
}
