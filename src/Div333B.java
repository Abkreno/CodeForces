import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div333B {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String l[] = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int prevPrev = -1, contLen = 1, prev = nums[0], max = 1, len = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] == prev) {
				contLen++;
				len++;
			} else if (nums[i] == prevPrev) {
				len++;
				prevPrev = prev;
				prev = nums[i];
				contLen = 1;
			} else if (Math.abs(nums[i] - prev) == 1) {
				len = contLen + 1;
				prevPrev = prev;
				prev = nums[i];
				contLen = 1;
			}
			max = Math.max(len, max);
		}
		System.out.println(max);
	}
}
