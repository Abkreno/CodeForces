package Div2_C;

import java.util.Arrays;
import java.util.Scanner;

public class FoxAndBoxAccumaltion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 1; i <= n; i++) {
			int[] tmp = new int[i];
			Arrays.fill(tmp, -1);
			int count = 0;
			boolean good = true;
			for (int j = n - 1; j >= 0; j--) {
				if (tmp[count] == -1) {
					tmp[count] = arr[j];
				} else {
					if (tmp[count] == 0) {
						good = false;
						break;
					}
					tmp[count] = Math.min(tmp[count] - 1, arr[j]);
				}
				count = (count + 1) % i;
			}
			if (good) {
				System.out.println(i);
				break;
			}
		}
	}
}
