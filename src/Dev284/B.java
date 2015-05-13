package Dev284;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int x = Integer.parseInt(l[1]);
		int nums[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			l = bf.readLine().split(" ");
			nums[i][0] = Integer.parseInt(l[0]);
			nums[i][1] = Integer.parseInt(l[1]);
		}
		int time = 1;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int start = nums[i][0];
			int end = nums[i][1];
			while (time + x <= start) {
				time += x;
			}
			res += end - time + 1;
			time = end + 1;
		}
		System.out.println(res);
	}
}
