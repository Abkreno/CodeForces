package Div268;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		boolean covered[] = new boolean[n];
		String[] l = bf.readLine().split(" ");
		int p = Integer.parseInt(l[0]);
		for (int i = 0; i < p; i++) {
			covered[Integer.parseInt(l[i + 1]) - 1] = true;
		}
		l = bf.readLine().split(" ");
		int c = Integer.parseInt(l[0]);
		for (int i = 0; i < c; i++) {
			covered[Integer.parseInt(l[i + 1]) - 1] = true;
		}
		boolean f = false;
		for (int i = 0; i < covered.length; i++) {
			if (!covered[i]) {
				System.out.println("Oh, my keyboard!");
				f = true;
				break;

			}
		}
		if (!f)
			System.out.println("I become the guy.");
	}

}
