package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GCDTable {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n * n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < n * n; i++) {
			arr[i] = Integer.parseInt(l[i]);
		}
		int max = n * (n - 1); // n*n - n
		int c = 0;
		Arrays.sort(arr);
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (c < max && arr[i] == arr[i + 1]) {
				c += 2;
				i++;
			} else {
				ans.append(arr[i] + " ");
			}
		}
		System.out.println(ans);
	}
}
