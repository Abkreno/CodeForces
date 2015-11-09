package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LittleElephantAndProb {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		int[] arr2 = new int[n];
		String[] l = bf.readLine().split(" ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(l[i]);
			arr2[i] = arr[i];
		}
		Arrays.sort(arr);
		int diffs = 0;
		for (int i = 0; i < l.length; i++) {
			if (arr[i] != arr2[i]) {
				diffs++;
				if (diffs > 2)
					break;
			}
		}
		System.out.println(diffs > 2 ? "NO" : "YES");
	}
}
