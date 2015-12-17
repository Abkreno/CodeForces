import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Div258B {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		int start = -1;
		int end = 0;
		boolean dec = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				if (start == -1) {
					start = i - 1;
					end = start;
					dec = true;
				} else if (!dec) {
					System.out.println("no");
					return;
				}
				end++;

			} else {
				dec = false;
			}
		}
		if (start == -1) {
			System.out.println("yes\n1 1");
			return;
		}
		for (int i = 0; i < start; i++) {
			if (nums[i] > nums[end]) {
				System.out.println("no");
				return;
			}
		}
		for (int i = end + 1; i < n; i++) {
			if (nums[i] < nums[start]) {
				System.out.println("no");
				return;
			}
		}
		System.out.println("yes");
		System.out.println((start + 1) + " " + (end + 1));
	}
}
