package Div271;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start[] = new int[n];
		int end[] = new int[n];
		int s = 1;
		for (int i = 0; i < n; i++) {
			int curr = sc.nextInt();
			start[i] = s;
			end[i] = s + curr - 1;
			s = end[i] + 1;
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int lo = 0;
			int hi = n - 1;
			int curr = sc.nextInt();
			loop: while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (start[mid] <= curr && end[mid] >= curr) {
					System.out.println(mid + 1);
					break loop;
				} else if (start[mid] > curr) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
	}
}
