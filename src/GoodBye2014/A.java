package GoodBye2014;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int x = Integer.parseInt(l[0]);
		int y = Integer.parseInt(l[1]);
		l = bf.readLine().split(" ");
		int nums[] = new int[x];

		for (int i = 0; i < l.length; i++) {
			nums[i] = Integer.parseInt(l[i]);
		}
		boolean flag = false;
		int c = 1;
		for (int i = 0; i < nums.length; i++) {
			c += nums[c - 1];
			if (c == y) {
				flag = true;
				break;
			} else if (c > y)
				break;
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
