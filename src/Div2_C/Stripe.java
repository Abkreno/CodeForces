package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stripe {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] l = bf.readLine().split(" ");
		int sums[] = new int[n];
		sums[0] = Integer.parseInt(l[0]);
		for (int i = 1; i < l.length; i++) {
			sums[i] = sums[i - 1] + Integer.parseInt(l[i]);
		}
		int count = 0;
		for (int i = 0; i < sums.length-1; i++) {
			if (sums[i] == sums[n - 1] - sums[i])
				count++;
		}
		System.out.println(count);
	}
}
