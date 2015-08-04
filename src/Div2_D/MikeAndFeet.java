package Div2_D;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MikeAndFeet {
	static class Bear implements Comparable<Bear> {
		int val, ind, left, right;
		boolean ignored, calc;

		Bear(int v, int i) {
			val = v;
			ind = i;
		}

		@Override
		public int compareTo(Bear o) {
			if (val > o.val)
				return 1;
			if (val < o.val)
				return -1;
			if (ind > o.ind)
				return 1;
			if (ind < o.ind)
				return -1;
			return 0;
		}

		public String toString() {
			if (ignored)
				return "Ignored";
			return left + right + 1 + "";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Bear[] original = new Bear[n];
		Bear[] sorted = new Bear[n];
		String[] l = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			original[i] = sorted[i] = new Bear(Integer.parseInt(l[i]), i);
		}
		Arrays.sort(sorted);
		Bear temp;
		int count;
		StringBuilder sb = new StringBuilder();
		int lastUncovered = 1;
		for (int i = n - 1; i >= 0; i--) {
			temp = sorted[i];
			if (sorted[i].calc || sorted[i].ignored)
				continue;
			sorted[i].calc = true;
			// go right
			count = 0;
			for (int j = temp.ind + 1; j < n; j++) {
				if (original[j].val > temp.val) {
					if (original[j].ignored) {
						count += original[j].right - j;
						j = original[j].right - 1;
					} else {
						count += original[j].right + 1;
						j += original[j].right;
					}
				} else {
					break;
				}
			}
			temp.right = count;

			// go left
			count = 0;
			for (int j = temp.ind - 1; j >= 0; j--) {
				if (original[j].val > temp.val) {
					count += original[j].left + 1;
					j -= original[j].left;
				} else if (original[j].val == temp.val) {
					original[j].ignored = true;
					original[j].right = i;
					count++;
				} else {
					break;
				}
			}
			temp.left = count;
			count = temp.left + temp.right + 1;
			for (int j = lastUncovered; j <= count; j++) {
				sb.append(temp.val + " ");
			}
			lastUncovered = Math.max(count + 1, lastUncovered);
			if (lastUncovered > n)
				break;
		}
		System.out.println(sb);
	}
}
