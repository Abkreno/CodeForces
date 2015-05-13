package Dev283;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n - 1; i++) {
			int temp = arr.remove(i);
			int maxDif = -1;
			for (int j = 0; j < n - 2; j++) {
				maxDif = Math.max(arr.get(j + 1) - arr.get(j), maxDif);
			}
			min = Math.min(min, maxDif);
			arr.add(i, temp);
		}
		System.out.println(min);
	}
}
