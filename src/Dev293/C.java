package Dev293;

import java.util.Scanner;

public class C {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] l = sc.nextLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);
		int k = Integer.parseInt(l[2]);
		int nums[] = new int[n];
		int q[] = new int[m];
		int indexes[] = new int[100001];
		l = sc.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(l[i]);
			indexes[nums[i]] = i;
		}
		l = sc.nextLine().split(" ");
		long res = 0;
		for (int i = 0; i < m; i++) {
			int curr = Integer.parseInt(l[i]);
			int pos = indexes[curr] + 1;
			int t = (int) Math.ceil((pos * 1.0) / (k * 1.0));

			res += t;
			// swap
			pos--;
			if (pos != 0) {
				indexes[nums[pos]]--;
				indexes[nums[pos - 1]]++;
				int temp = nums[pos];
				nums[pos] = nums[pos - 1];
				nums[pos - 1] = temp;
			}
		}
		System.out.println(res);
	}
}
