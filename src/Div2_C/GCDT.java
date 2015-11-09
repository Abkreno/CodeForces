package Div2_C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeMap;

public class GCDT {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n * n];
		String[] l = bf.readLine().split(" ");
		int c;
		TreeMap<Integer, Integer> counts = new TreeMap<>((x, y) -> y - x);

		for (int i = 0; i < n * n; i++) {
			arr[i] = Integer.parseInt(l[i]);
			c = 1;
			if (counts.containsKey(arr[i])) {
				c += counts.get(arr[i]);
			}
			counts.put(arr[i], c);
		}
		int[] ans = new int[n];
		LinkedList<Integer> numbers = new LinkedList<>();
		numbers.addAll(counts.keySet());
		int size = 0, gcd;
		for (int i : numbers) {
			while (counts.get(i) > 0) {
				ans[size] = i;
				counts.put(i, counts.get(i) - 1);
				for (int j = 0; j < size; j++) {
					gcd = gcd(i, ans[j]);
					counts.put(gcd, counts.get(gcd) - 2);
				}
				size++;
			}
		}
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static int gcd(int a, int b) {
		while (a % b != 0 && b % a != 0) {
			if (a < b) {
				b = b % a;
			} else {
				a = a % b;
			}
		}
		return Math.min(a, b);
	}
}
