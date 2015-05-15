package Div277;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int p = Integer.parseInt(l[1]) - 1;
		int[] dist = new int[n];
		int j = n - 1;
		char[] chars = bf.readLine().toCharArray();
		for (int i = 0; i < dist.length / 2; i++, j--) {
			dist[i] = calcDist(chars[i], chars[j]);
			dist[j] = dist[i];
		}
		int res = 0;
		if (p > n / 2) {
			int start = p;
			int end = p;
			for (int i = p; i < n; i++) {
				if (dist[i] != 0) {
					end = i;
				}
			}
			for (int i = p; i > n / 2; i--) {
				if (dist[i] != 0) {
					start = i;
				}
			}
			if (end - p < p - start) {
				// go right
				for (int i = p; i < n; i++) {
					res += 2 + dist[i];
				}
				for (int i = p - 1; i > n / 2; i--) {
					res += 1 + dist[i];
				}
				res -= 2;
			} else {
				// go left
				for (int i = p; i > n / 2; i--) {
					res += 2 + dist[i];
				}
				for (int i = p + 1; i < n; i++) {
					res += 1 + dist[i];
				}
				res -= 2;

			}
		} else {
			int start = p;
			int end = p;
			for (int i = p; i < n / 2; i++) {
				if (dist[i] != 0) {
					end = i;
				}
			}
			for (int i = p; i >= 0; i--) {
				if (dist[i] != 0) {
					start = i;
				}
			}
			if (end - p < p - start) {
				// go right
				for (int i = p; i < n / 2; i++) {
					res += 2 + dist[i];
				}
				for (int i = p - 1; i >= 0; i--) {
					res += 1 + dist[i];
				}
				res -= 2;
			} else {
				// go left
				for (int i = p; i >= 0; i--) {
					res += 2 + dist[i];
				}
				for (int i = p + 1; i < n / 2; i++) {
					res += 1 + dist[i];
				}
				res -= 2;
			}
		}
		System.out.println(res);
	}

	private static int calcDist(char c, char d) {
		if (d < c) {
			char t = c;
			c = d;
			d = t;
		}
		int normal = Math.abs(c - d);
		int reverse = 'z' - d + c + 1;
		reverse -= 'a';
		return Math.min(reverse, normal);
	}
}
