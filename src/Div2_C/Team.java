package Div2_C;

import java.util.Arrays;
import java.util.Scanner;

public class Team {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int zeros = sc.nextInt();
		int ones = sc.nextInt();
		int[] list = new int[zeros + ones];
		Arrays.fill(list, -1);
		int index = 0;
		if (zeros > 0) {
			list[index++] = 0;
			zeros--;
		}
		int cons = 0;
		while (zeros > 0 && ones > 0) {
			list[index++] = 1;
			ones--;
			if (ones > 0) {
				list[index++] = 1;
				ones--;
				cons++;
			}
			list[index++] = 0;
			zeros--;
		}
		boolean good = true;
		int lastOnes = 0;
		int firstOnes = 0;
		if (ones > 0) {
			if (ones > 4 || (ones > 2 && list[index - 1] == 1)) {
				good = false;
			} else {
				while (ones > 2) {
					lastOnes++;
					ones--;
				}
				while (ones > 0) {
					firstOnes++;
					ones--;
				}
			}
		} else {
			if (zeros > cons) {
				good = false;
			}
		}
		int prev = -1;
		if (good) {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < firstOnes; i++) {
				result.append(1);
			}
			for (int i = 0; i < index; i++) {
				if (prev == 1 && list[i] == 1 && zeros > 0) {
					result.append(0);
					zeros--;
				}
				result.append(list[i]);
				prev = list[i];
			}
			for (int i = 0; i < lastOnes; i++) {
				result.append(1);
			}
			System.out.println(result);
		} else {
			System.out.print(-1);
		}
		System.out.println();
	}
}
