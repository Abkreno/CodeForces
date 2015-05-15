package Div288;

import java.util.HashMap;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int pix = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[rows][pix];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (!map.containsKey((x - 1) + " " + (y - 1)))
				map.put((x - 1) + " " + (y - 1), i + 1);
			arr[x - 1][y - 1] = 1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < pix - 1; j++) {
				if (arr[i][j] == 1) {
					if (arr[i + 1][j] == 1) {
						if (arr[i][j + 1] == 1) {
							if (arr[i + 1][j + 1] == 1) {
								int max = 0;
								max = Math.max(max, map.get(i + " " + j));
								max = Math.max(max, map.get((i + 1) + " " + j));
								max = Math.max(max,
										map.get((i) + " " + (j + 1)));
								max = Math.max(max,
										map.get((i + 1) + " " + (j + 1)));
								min = Math.min(min, max);
							}
						}
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);

	}
}
